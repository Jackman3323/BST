
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
        root = null;
    }
    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if(x==null) return 0;
        else return size(x.getLeft()) + 1 + size(x.getRight()); //+1 for each time it's not null, check the other subtrees
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if(n.getKey().compareTo(key) > 0) {
            //n key is greater than passed key, go left or place lft
            if(n.getLeft() != null) {
                return this.put(n.getLeft(), key, val);
            }
            else if(n.getLeft().getKey() == key) return n.getLeft();
            else {
                n.setLeft(new Node<Key,Value>(key,val,0));
                n.setSize(n.getSize() + 1);
                return n;
            }
        } else if(n.getKey().compareTo(key) < 0) {
            //n key is less than passed key, go right or place right
            if(n.getRight() != null) {
                return this.put(n.getRight(), key, val);
            }
            else if(n.getRight().getKey() == key) return n.getRight();
            else {
                n.setRight(new Node<Key,Value>(key,val,0));
                n.setSize(n.getSize() + 1);
                return n;
            }
        } else return n; //Here for the edge case that the root key == the passed key
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null) {
            return null;
        }
        else if(n.getKey() == key) {
            return n.getValue();
        }
        else if(n.getKey().compareTo(key) < 0 ) {
            return get(n.getRight(),key);
        }
        else return get(n.getLeft(),key);
    }

    public boolean contains(Key key) {
        return this.get(key) != null;
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if(n.getLeft() == null) {
            return n;
        }
        else return this.min(n.getLeft());
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if(n.getRight() == null) {
            return n;
        }
        else return this.max(n.getRight());
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}
