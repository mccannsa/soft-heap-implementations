template <typename T>
class Item {
    private:
        T key;
        Item<T>* next;

    public:
        Item(T k);
        T getKey();
        void setKey(T k);
        Item<T> getNext();
        void setNext(Item<T> n);
};