/**
 * BST_Driver.java
 *
 * This driver tests all the functionality of the BinarySearchTree.java file. If all prefixes match their suffixes, the
 * Binary Search Tree works.
 *
 * Authors: Jack Hughes
 * Date: 5-20-21
 * -JBH
 */
public class BST_Driver {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
        System.out.println("SHOULD SAY TRUE: " + BST.isEmpty());
        BST.put(5, "I AM THE ROOT NODE");
        BST.put(11,"I AM TO THE RIGHT OF THE ROOT NODE");
        BST.put(12,"I AM THE MAXIMUM VALUE OF THE TREE");
        BST.put(3,"I AM TO THE LEFT OF THE ROOT NODE");
        BST.put(1, "I AM THE MINIMUM VALUE");
        System.out.println("SHOULD SAY ROOT NODE: " + BST.get(5));
        System.out.println("SHOULD SAY RIGHT OF ROOT: " + BST.get(11));
        System.out.println("SHOULD SAY MAXIMUM: " + BST.get(12));
        System.out.println("SHOULD SAY 5: " + BST.size());
        System.out.println("SHOULD SAY 1: " + BST.min());
        System.out.println("SHOULD SAY 12: " + BST.max());
        System.out.println("SHOULD SAY TRUE: " + BST.contains(1));
        System.out.println("SHOULD SAY MINIMUM: " + BST.remove(1));
        System.out.println("SHOULD SAY 4: " + BST.size());
        System.out.println("SHOULD SAY FALSE: " + BST.contains(1));
    }
}
