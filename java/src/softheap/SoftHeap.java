package softheap;

public class SoftHeap<T extends Comparable<T>> {
    private Node<T> minroot;
    public Node<T> nil;
    private int t;

    public SoftHeap(double eps) {
        t = (int) Math.ceil(Math.log(3 / eps) / Math.log(2));
        minroot = makeHeap();
    }

    /**
     * Creates the Nil node to instantiate the soft heap.
     * 
     * @return a pointer to the minroot of the heap
     */
    public Node<T> makeHeap() {
        nil = new Node<T>();
        nil.setItems(null);
        nil.setKey(null);
        nil.setRank(Integer.MAX_VALUE);
        nil.setLeft(nil);
        nil.setRight(nil);
        nil.setNext(nil);
        return nil;
    }

    /**
     * Finds the minimum element in the soft heap.
     * 
     * @return a size-2 array A where A[0] contains the item being removed and
     *         A[1] contains the key of the root node
     */
    public Object[] findMin() {
        return new Object[] { minroot.getItems().getNext(), minroot.getKey() };
    }

    /**
     * Removes the minimum element in the soft heap.
     * 
     * Node sets are implemented using a circularly-linked list. If there is
     * more than one item in the set, then we remove the last item using
     * pointer manipulation. If there is only one item in the set, empty the
     * set. Then check if the node has children. If there are no children,
     * update the minimum root node and destroy the empty node. Otherwise,
     * perform a defill operation. Finally, reorder the root list if the
     * minimum root was emptied.
     * 
     * @return the current minimum root
     */
    public Node<T> deleteMin() {
        Item<T> e = minroot.getItems().getNext();
        if (e.getNext() != e) {
            minroot.getItems().setNext(e.getNext());
            return minroot;
        } else {
            minroot.setItems(null);
            int k = minroot.getRank();
            if (minroot.getLeft() == nil) {
                minroot = minroot.getNext();
            } else {
                defill(minroot, false);
            }
            minroot = reorder(minroot, k);
            return minroot;
        }
    }

    /**
     * Inserts an item into the soft heap.
     * 
     * @param e the item to insert
     * 
     * @return the minroot
     */
    public Node<T> insert(Item<T> e) {
        minroot = keySwap(meldableInsert(makeRoot(e), rankSwap(minroot)));
        return minroot;
    }

    /**
     * Melds two existing heaps into one heap.
     * 
     * @param H1 the first heap
     * @param H2 the second heap
     *
     * @return the minroot of the resultant heap
     */
    public Node<T> meld(Node<T> H1, Node<T> H2) {
        return keySwap(meldableMeld(rankSwap(H1), rankSwap(H2)));
    }

    public boolean isEmpty() {
        return minroot == nil;
    }

    public String toString() {
        String str = "";
        for (Node<T> n = minroot; n != nil; n = n.getNext()) {
            str += stringifyTree(n, 0);
            str += "\n-----\n";
        }
        return str;
    }

    private void defill(Node<T> x, boolean inserting) {
        fill(x, inserting);
        if (inserting && x.getRank() > t && x.getRank() % 2 == 0 && x.getLeft() != null) {
            fill(x, inserting);
        }
    }

    private void fill(Node<T> x, boolean inserting) {
        if (x.getLeft() != nil && x.getRight() != nil && x.getLeft().getKey().compareTo(x.getRight().getKey()) > 0) {
            Node<T> temp = x.getLeft();
            x.setLeft(x.getRight());
            x.setRight(temp);
        }

        x.setKey(x.getLeft().getKey());

        if (x.getItems() == null) {
            x.setItems(x.getLeft().getItems());
        } else {
            Item<T> temp = x.getItems().getNext();
            x.getItems().setNext(x.getLeft().getItems().getNext());
            x.getLeft().getItems().setNext(temp);
        }

        x.getLeft().setItems(null);

        if (x.getLeft().getLeft() == nil) {
            x.setLeft(x.getRight());
            x.setRight(nil);
        } else {
            defill(x.getLeft(), inserting);
        }
    }

    public Node<T> rankSwap(Node<T> H) {
        Node<T> x = H.getNext();
        if (H.getRank() <= x.getRank())
            return H;

        H.setNext(x.getNext());
        x.setNext(H);
        return x;
    }

    private Node<T> keySwap(Node<T> H) {
        Node<T> x = H.getNext();
        if (x == nil)
            return H;
        if (H.getKey().compareTo(x.getKey()) <= 0)
            return H;

        H.setNext(x.getNext());
        x.setNext(H);
        return x;
    }

    private Node<T> reorder(Node<T> H, int k) {
        if (H.getNext().getRank() < k) {
            H = rankSwap(H);
            H.setNext(reorder(H.getNext(), k));
        }
        return keySwap(H);
    }

    public Node<T> makeRoot(Item<T> e) {
        Node<T> x = new Node<T>();
        e.setNext(e);
        x.setItems(e);
        x.setKey(e.getKey());
        x.setRank(0);
        x.setLeft(nil);
        x.setRight(nil);
        x.setNext(nil);
        return x;
    }

    public Node<T> meldableInsert(Node<T> x, Node<T> H) {
        if (x.getRank() < H.getRank()) {
            x.setNext(keySwap(H));
            return x;
        }
        return meldableInsert(link(x, H), rankSwap(H.getNext()));
    }

    private Node<T> link(Node<T> x, Node<T> y) {
        Node<T> z = new Node<T>();
        z.setItems(null);
        z.setRank(x.getRank() + 1);
        z.setLeft(x);
        z.setRight(y);
        defill(z, true);
        return z;
    }

    private Node<T> meldableMeld(Node<T> H1, Node<T> H2) {
        if (H1.getRank() > H2.getRank()) {
            Node<T> temp = H1;
            H1 = H2;
            H2 = temp;
        }

        if (H2 == nil)
            return H1;

        return meldableInsert(H1, meldableMeld(rankSwap(H1.getNext()), H2));
    }

    private String stringifyTree(Node<T> n, int level) {
        if (n == nil) return "";

        String str = String.format("k: %s; r: %d; [%s", n.getKey(), n.getRank(), n.getItems().getNext().getKey());
        for (Item<T> i = n.getItems().getNext().getNext(); i != n.getItems().getNext(); i = i.getNext()) {
            str += " " + i.getKey();
        }
        str += "]\n";

        String tabs = "";
        for (int i = 0; i < level + 1; i++) {
            tabs += "|\t";
        }

        String left = stringifyTree(n.getLeft(), level + 1);
        String right = stringifyTree(n.getRight(), level + 1);

        if (!left.isEmpty())
            str += tabs + left;
        else
            str += tabs + "null\n";
        
        if (!right.isEmpty())
            str += tabs + right;
        else
            str += tabs + "null\n";

        return str;
    }
}
