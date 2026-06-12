// Kosta Lekos
// June 9th, 2026
// TaskManager.java
// This class will manage a collection of tasks using a BST<Task>.
// It should provide methods to add, delete, search, and print tasks by priority.
package tree;

import tree.BST.TreeNode;

public class TaskManager {
    // TO IMPLEMENT: Add methods to manage tasks using BST<Task>
    public void add(E value) {
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












    public static void main(String[] args) {
        // TO IMPLEMENT: Create a TaskManager object
        // Use the TaskManager to insert tasks, search, delete, and print in priority order
        // This serves as your main test harness
    }
}
