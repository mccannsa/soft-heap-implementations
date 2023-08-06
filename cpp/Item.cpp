using namespace std;

#include "Item.h"

template <typename T>
Item<T>::Item(T k) {
    this->key = k;
    this->next = this;
}

template <typename T>
T Item<T>::getKey() {
    return key;
}

template <typename T>
void Item<T>::setKey(T k) {
    key = k;
}

template <typename T>
Item<T> Item<T>::getNext() {
    return next;
}

template <typename T>
void Item<T>::setNext(Item<T> n) {
    next = n;
}
