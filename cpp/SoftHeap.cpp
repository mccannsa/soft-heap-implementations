using namespace std;

#include <cmath>
#include <iostream>
#include <limits.h>
#include <sstream>
#include <vector>

template <typename T>
class Item {
    private:
        T key;
        Item<T>* next;

    public:
        Item(T* k) {
            this->key = *k;
            this->next = this;
        };

        T* getKey() {
            return &(this->key);
        };

        Item<T>* getNext() {
            return this->next;
        };

        void setNext(Item<T>* n) {
            this->next = n;
        };
};

template <typename T>
class Node {
    private:
        Item<T>* items;
        T* key;
        int rank;
        Node<T>* left;
        Node<T>* right;
        Node<T>* next;

    public:
        Node() {
            this->items = nullptr;
            this->key = nullptr;
            this->rank = 0;
            this->left = nullptr;
            this->right = nullptr;
            this->next = nullptr;
        };

        Item<T>* getItems() {
            return this->items;
        };

        void setItems(Item<T>* item) {
            this->items = item;
        };

        T* getKey() {
            return this->key;
        };

        void setKey(T* k) {
            this->key = k;
        };

        int getRank() {
            return this->rank;
        };

        void setRank(int r) {
            this->rank = r;
        };

        Node<T>* getLeft() {
            return this->left;
        };

        void setLeft(Node<T>* l) {
            this->left = l;
        };
        
        Node<T>* getRight() {
            return this->right;
        };

        void setRight(Node<T>* r) {
            this->right = r;
        };
        
        Node<T>* getNext() {
            return this->next;
        };

        void setNext(Node<T>* n) {
            this->next = n;
        };
};

template <typename T>
class SoftHeap {
    private:
        Node<T>* minroot;
        Node<T>* nil;
        int t;

    public:
        SoftHeap(double eps) {
            t = (int) ceil(log(3 / eps) / log(2));
            minroot = makeHeap();
        };

        Node<T>* makeHeap() {
            nil = new Node<T>();
            nil->setItems(nullptr);
            nil->setKey(nullptr);
            nil->setRank(INT_MAX);
            nil->setLeft(nil);
            nil->setRight(nil);
            nil->setNext(nil);
            return nil;
        };

        struct min {
            Item<T>* item;
            T* nKey;
        };

        min findMin() {
            min m;
            m.item = minroot->getItems()->getNext();
            m.nKey = minroot->getKey();
            return m;
        };

        Node<T>* deleteMin() {
            Item<T>* e = minroot->getItems()->getNext();
            if (e->getNext() != e) {
                minroot->getItems()->setNext(e->getNext());
                return minroot;
            } else {
                minroot->setItems(nullptr);
                int k = minroot->getRank();
                if (minroot->getLeft() == nil) {
                    minroot = minroot->getNext();
                } else {
                    defill(minroot, false);
                }
                minroot = reorder(minroot, k);
                return minroot;
            }
        };

        Node<T>* insert(Item<T>* e) {
            minroot = keySwap(meldableInsert(makeRoot(e), rankSwap(minroot)));
            return minroot;
        };

        Node<T>* meld(Node<T>* H1, Node<T>* H2) {
            return keySwap(meldableMeld(rankSwap(H1), rankSwap(H2)));
        };

        bool isEmpty() {
            return minroot == nil;
        };

        string toString() {
            string str = "";
            for (Node<T>* n = minroot; n != nil; n = n->getNext()) {
                str += stringifyTree(n, 0);
                str += "\n-----\n";
            }
            return str;
        };

        void defill(Node<T>* x, bool inserting) {
            fill(x, inserting);
            if (inserting && x->getRank() > t && x->getRank() % 2 == 0 && x->getLeft() != nullptr) {
                fill(x, inserting);
            }
        };

        void fill(Node<T>* x, bool inserting) {
            if (x->getLeft() != nil && x->getRight() != nil && x->getLeft()->getKey() > x->getRight()->getKey()) {
                Node<T>* temp = x->getLeft();
                x->setLeft(x->getRight());
                x->setRight(temp);
            }

            x->setKey(x->getLeft()->getKey());

            if (x->getItems() == nullptr) {
                x->setItems(x->getLeft()->getItems());
            } else {
                Item<T>* temp = x->getItems()->getNext();
                x->getItems()->setNext(x->getLeft()->getItems()->getNext());
                x->getLeft()->getItems()->setNext(temp);
            }

            x->getLeft()->setItems(nullptr);

            if (x->getLeft()->getLeft() == nil) {
                x->setLeft(x->getRight());
                x->setRight(nil);
            } else {
                defill(x->getLeft(), inserting);
            }
        };

        Node<T>* rankSwap(Node<T>* H) {
            Node<T>* x = H->getNext();
            if (H->getRank() <= x->getRank())
                return H;

            H->setNext(x->getNext());
            x->setNext(H);
            return x;
        };

        Node<T>* keySwap(Node<T>* H) {
            Node<T>* x = H->getNext();
            if (x == nil)
                return H;
            if (H->getKey() <= x->getKey())
                return H;

            H->setNext(x->getNext());
            x->setNext(H);
            return x;
        };

        Node<T>* reorder(Node<T>* H, int k) {
            if (H->getNext()->getRank() < k) {
                H = rankSwap(H);
                H->setNext(reorder(H->getNext(), k));
            }
            return keySwap(H);
        };

        Node<T>* makeRoot(Item<T>* e) {
            Node<T>* x = new Node<T>();
            e->setNext(e);
            x->setItems(e);
            x->setKey(e->getKey());
            x->setRank(0);
            x->setLeft(nil);
            x->setRight(nil);
            x->setNext(nil);
            return x;
        };

        Node<T>* meldableInsert(Node<T>* x, Node<T>* H) {
            if (x->getRank() < H->getRank()) {
                x->setNext(keySwap(H));
                return x;
            }
            return meldableInsert(link(x, H), rankSwap(H->getNext()));
        };

        Node<T>* link(Node<T>* x, Node<T>* y) {
            Node<T>* z = new Node<T>();
            z->setItems(nullptr);
            z->setRank(x->getRank() + 1);
            z->setLeft(x);
            z->setRight(y);
            defill(z, true);
            return z;
        };

        Node<T>* meldableMeld(Node<T>* H1, Node<T>* H2) {
            if (H1->getRank() > H2->getRank()) {
                Node<T>* temp = H1;
                H1 = H2;
                H2 = temp;
            }

            if (H2 == nil)
                return H1;

            return meldableInsert(H1, meldableMeld(rankSwap(H1->getNext()), H2));
        };

        string stringifyTree(Node<T>* n, int level) {
            if (n == nil) return "";
            string k = "k: ";
            string r = "; r: ";
            string i = "; [";
            string s = " ";

            stringstream str;
            str << k << *(n->getKey()) << r << std::to_string(n->getRank()) << i << *(n->getItems()->getNext()->getKey());
            for (Item<T>* i = n->getItems()->getNext()->getNext(); i != n->getItems()->getNext(); i = i->getNext()) {
                str << s << *(i->getKey());
            }
            str << "]\n";

            string tabs = "";
            for (int i = 0; i < level + 1; i++) {
                tabs += "|\t";
            }

            string left = stringifyTree(n->getLeft(), level + 1);
            string right = stringifyTree(n->getRight(), level + 1);

            if (!left.empty())
                str << tabs + left;
            else
                str << tabs << "null\n";
            
            if (!right.empty())
                str << tabs + right;
            else
                str << tabs << "null\n";

            return str.str();
        };
};

int main(int argc, char** argv) {
    cout << "init soft heap" << endl;
    SoftHeap<int>* sh = new SoftHeap<int>(0.5);
    
    cout << "inserting" << endl;
    for (int i = 0; i < 100; i++) {

        Item<int>* item = new Item<int>(&i);

        cout << *(item->getKey()) << " " << item->getKey() << endl;
        cout << sh->toString() << endl;

        sh->insert(item);

        cout << sh->toString() << endl;
    }
}