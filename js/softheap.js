class Item {
  key;
  next;
  constructor(key) {
    this.key = key;
    this.next = this;
  }
}

class Node {
  constructor() {}
}

let nil = new Node();
nil.set = nil;
nil.key = Infinity;
nil.rank = Infinity;
nil.left = nil;
nil.right = nil;
nil.next = nil;

let T = Infinity;

function threshold(eps) {
  T = Math.ceil(Math.log2(3 / eps));
}

function make_heap() {
  return nil;
}

function find_min(H) {
  return { item: H.set.next, key: H.key };
}

function delete_min(H) {
  let elem = H.set.next;
  if (elem.next != elem) {
    H.set.next = elem.next;
    return H;
  } else {
    H.set = null;
    let k = H.rank;
    if (H.left == nil) {
      H = H.next;
    } else {
      defill(H, false);
    }
    H = reorder(H, k);
    return H;
  }
}

function insert(elem, H) {
  H = key_swap(meldable_insert(make_root(elem), rank_swap(H)));
  return H;
}

function meld(H1, H2) {
  return key_swap(meldable_meld(rank_swap(H1), rank_swap(H2)));
}

function defill(x, inserting) {
  fill(x, inserting);
  if (inserting && x.rank > T && x.rank % 2 == 0 && x.left != nil) {
    fill(x, inserting);
  }
}

function fill(x, inserting) {
  if (x.left != nil && x.right != nil && x.left.key > x.right.key) {
    let temp = x.left;
    x.left = x.right;
    x.right = temp;
  }

  x.key = x.left.key;

  if (x.set == null) {
    x.set = x.left.set;
  } else {
    let temp = x.set.next;
    x.set.next = x.left.set.next;
    x.left.set.next = temp;
  }

  x.left.set = null;

  if (x.left.left.key == Infinity) {
    x.left = x.right;
    x.right = nil;
  } else {
    defill(x.left, inserting);
  }
}

function rank_swap(H) {
  let x = H.next;
  if (H.rank <= x.rank) {
    return H;
  }
  H.next = x.next;
  x.next = H;
  return x;
}

function key_swap(H) {
  let x = H.next;
  if (H.key < x.key) {
    return H;
  }
  H.next = x.next;
  x.next = H;
  return x;
}

function reorder(H, k) {
  if (H.next.rank < k) {
    H = rank_swap(H);
    H.next = reorder(H.next, k);
  }
  return key_swap(H);
}

function make_root(elem) {
  let x = new Node();
  elem.next = elem;
  x.set = elem;
  x.key = elem.key;
  x.rank = 0;
  x.left = nil;
  x.right = nil;
  x.next = nil;
  return x;
}

function link(x, y) {
  let z = new Node();
  z.set = null;
  z.rank = x.rank + 1;
  z.left = x;
  z.right = y;
  defill(z, true);
  return z;
}

function meldable_insert(x, H) {
  if (x.rank < H.rank) {
    x.next = key_swap(H);
    return x;
  }
  return meldable_insert(link(x, H), rank_swap(H.next));
}

function meldable_meld(H1, H2) {
  if (H1.rank > H2.rank) {
    let temp = H1;
    H1 = H2;
    H2 = temp;
  }

  if (H2 == nil) {
    return H1;
  }

  meldable_insert(H1, meldable_meld(rank_swap(H1.next), H2));
}

export { Item, find_min, delete_min, insert, make_heap, meld, threshold };
