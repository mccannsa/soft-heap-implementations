package softheap;

public class Node<T extends Comparable<T>> {
    private Item<T> items;
    private T key;
    private int rank;
    private Node<T> left, right, next;

    public Item<T> getItems() {
        return items;
    }

    public void setItems(Item<T> item) {
        items = item;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
