template <typename T>
class Node {
    private:
        Item<T> items;
        T key;
        int rank;
        Node<T> left;
        Node<T> right;
        Node<T> next;

    public:
        Node();
        Item<T> getItems();
        void setItems(Item<T> item);
        T getKey();
        void setKey(T k);
        int getRank();
        void setRank(int r);
        Node<T> getLeft();
        void setLeft(Node<T> l);
        Node<T> getRight();
        void setRight(Node<T> r);
        Node<T> getNext();
        void setNext(Node<T> n);
};