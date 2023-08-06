package softheap;

public class Item<T extends Comparable<T>> {
    private T key;
    private Item<T> next;

    public Item(T key) {
        this.key = key;
        this.next = this;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }
}
