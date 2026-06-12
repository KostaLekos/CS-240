// Kosta Lekos
// June 9th, 2026
// BST.java
// This class defines a generic Binary Search Tree (BST) data structure.
// It uses a nested TreeNode class to represent each node in the tree.
// The tree stores elements of any type E that implements Comparable<E>.

public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root; // The root node of the BST
    protected int size = 0;     // Keeps track of the number of nodes in the tree

    // Default constructor for an empty tree
    public BST() {
        this.root = null;
    }

    public BST(E root) {
        this.root = new TreeNode<>(root);
    }

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

    public void preorder() {
        preorder(root);
        System.out.println(); // Print a newline after traversal output
    }

    public void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");   // print current
            preorder(root.left);                 // left subtree
            preorder(root.right);                // right subtree
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println(); // Print a newline after traversal output
    }

    public void postorder(TreeNode<E> root) {
        if (root != null) {
            postorder(root.left);                 // left subtree
            postorder(root.right);                // right subtree
            System.out.print(root.element + " ");    // print current
        }
    }

    // Method to get the number of nodes in the BST
    public int size() {
        return size;
    }
    
    public boolean search(E value) {
        TreeNode<E> current = root;
        
        while (current != null) {
            int cmp = value.compareTo(current.element);
            if (cmp == 0) return true;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return false; // not found
    }
    
    
    public boolean delete(E value) {
        if (root == null) return false;
        
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        int cmp = value.compareTo(current.element);        
        while (current != null && cmp != 0) {
            parent = current;
            if (cmp < 0) current = current.left;
            else current = current.right;
            cmp = value.compareTo(current.element);        
        }
        if (current == null) return false; // value not found
        
        // if node has two children
        if (current.left != null && current.right != null) {
            // find in-order successor (smallest in right subtree)
            TreeNode<E> succParent = current;
            TreeNode<E> succ = current.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            
            // copy successor value to current node
            current.element = succ.element;
            
            // remove successor
            parent = succParent;
            current = succ;
        }
        
        // if node has 0 or 1 child
        TreeNode<E> child = (current.left != null) ? current.left : current.right;
        
        if (parent == null) {
            root = child; // remove root
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        
        return true;
    }
    
    public void insert(E value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }

        TreeNode<E> current = root;

        while (true) {
            int cmp = value.compareTo(current.element);
            if (cmp == 0) {
                return;
            } else if (cmp < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode<E>(value);
                    return;
                }
            } else if (cmp > 0) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode<E>(value);
                    return;
                }
            }
        }
    }

    public TreeNode<E> get(E value) {
        TreeNode<E> current = root;

        while (current != null) {
            int cmp = value.compareTo(current.element);
            if (cmp == 0) return current;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null; // not found
    }

    public TreeNode<E> getRoot() {
        return root;
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
}