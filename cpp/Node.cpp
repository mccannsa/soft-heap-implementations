using namespace std;

#include "Item.h"
#include "Node.h"

template<typename T>
Item<T> Node<T>::getItems() {
    return items;
}

template<typename T>
void Node<T>::setItems(Item<T> item) {
    items = item;
}

template<typename T>
T Node<T>::getKey() {
    return key;
}

template<typename T>
void Node<T>::setKey(T k) {
    key = k;
}

template<typename T>
int Node<T>::getRank() {
    return rank;
}

template<typename T>
void Node<T>::setRank(int r) {
    rank = r;
}

template<typename T>
Node<T> Node<T>::getLeft() {
    return left;
}

template<typename T>
void Node<T>::setLeft(Node<T> l) {
    left = l;
}

template<typename T>
Node<T> Node<T>::getRight() {
    return right;
}

template<typename T>
void Node<T>::setRight(Node<T> r) {
    right = r;
}

template<typename T>
Node<T> Node<T>::getNext() {
    return next;
}

template<typename T>
void Node<T>::setNext(Node<T> n) {
    next = n;
}
