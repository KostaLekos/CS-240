// BST.java
// This class defines a generic Binary Search Tree (BST) data structure.
// It uses a nested TreeNode class to represent each node in the tree.
// The tree stores elements of any type E that implements Comparable<E>.
public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root; // The root node of the BST
    protected int size = 0;     // Keeps track of the number of nodes in the tree

    // Default constructor for an empty tree
    public BST() {}

    // Public method to get the height of the tree
    public int height() {
        return height(root);
    }

    // Private helper method to compute the height recursively
    private int height(TreeNode<E> node) {
        if (node == null) return 0; // Base case: empty subtree
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Public method to perform inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println(); // Print a newline after traversal output
    }

    // Recursive helper for inorder traversal
    private void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);             // Visit left subtree
            System.out.print(root.element + " "); // Visit current node
            inorder(root.right);            // Visit right subtree
        }
    }

    // Nested TreeNode class to represent each node in the tree
    public static class TreeNode<E> {
        protected E element;        // The data stored at this node
        protected TreeNode<E> left; // Reference to the left child
        protected TreeNode<E> right;// Reference to the right child

        // Constructor initializes the node with data
        public TreeNode(E e) {
            element = e;
        }
    }

    // Method to get the number of nodes in the BST
    public int size() {
        return size;
    }
}
