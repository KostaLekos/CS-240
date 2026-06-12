// Kosta Lekos
// June 9th, 2026
// TaskManager.java
// This class will manage a collection of tasks using a BST<Task>.
// It should provide methods to add, delete, search, and print tasks by priority.


public class TaskManager {

    public static void insertTask(int priority, String description, BST<Task> tree) {
        Task t = new Task(priority, description);
        tree.insert(t);
    }

    public static void printTasks(BST<Task> tree) {
        System.out.println("Tasks in order of priority (highest to lowest): ");
        tree.inorder();
    }

    public static String findTask(int priority, BST<Task> tree) {
        Task tempT = new Task(priority, null);
        BST.TreeNode<Task> node = tree.get(tempT);
        if (node != null) {
            return node.element.getDescription();
        } else {
            return "Not found";
        }
    }

    public static void deleteTask(int priority, BST<Task> tree) {
        Task tempT = new Task(priority, null);
        tree.delete(tempT);
    }


    public static void main(String[] args) {
        BST<Task> taskTree = new BST<>();
        
        insertTask(5, "Do homework", taskTree);
        insertTask(2, "Wash dishes", taskTree);
        insertTask(8, "Study for exam", taskTree);
        insertTask(1, "Take out trash", taskTree);
        insertTask(6, "Go grocery shopping", taskTree);
        
        System.out.println();
        
        printTasks(taskTree);
        
        System.out.println();
        
        System.out.println("Priority 8: " + findTask(8, taskTree));
        
        System.out.println();
        
        System.out.println("Deleting Task with priority 2: ");
        deleteTask(2, taskTree);
        
        System.out.println();
        
        printTasks(taskTree);
        
        System.out.println();
        
        System.out.println("Priority 2: " + findTask(2, taskTree));
        
        // BST<Integer> intTree = new BST<Integer>();
        // 
        // intTree.insert(5);
        // intTree.insert(2);
        // intTree.insert(8);
        // intTree.insert(1);
        // intTree.insert(6);
        // 
        // System.out.println("Initial tree:");
        // intTree.inorder();
        // 
        // System.out.println("\nContains 6: " + intTree.search(6));
        // System.out.println("Contains 3: " + intTree.search(3));
        // 
        // intTree.delete(2);
        // 
        // System.out.println("\nAfter deleting 2:");
        // intTree.inorder();
        // 
        // System.out.println("\nContains 2: " + intTree.search(2));
    }
}
