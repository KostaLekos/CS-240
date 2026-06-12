// Kosta Lekos
// 06/12/2026
public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<String> stringSearchTree = new AVLTree<>();
        AVLTree<Integer> integerSearchTree = new AVLTree<>();

        String[] dataset_strings = {
                "apple", "apricot", "banana", "blueberry", "blackberry",
                "cherry", "cranberry", "cantaloupe", "date", "dragonfruit",
                "elderberry", "fig", "grapefruit", "grape", "guava",
                "honeydew", "kiwi", "lemon", "lime", "mango",
                "nectarine", "orange", "papaya", "peach", "pear",
                "pineapple", "plum", "pomegranate", "raspberry", "strawberry",
                "tangerine", "watermelon"
        };

        int[] dataset_integers = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };

        for (String word : dataset_strings) {
            stringSearchTree.insert(word);
        }

        for (int num : dataset_integers) {
            integerSearchTree.insert(num);
        }

        System.out.println("\nAVL Tree Structure (Strings):");
        stringSearchTree.printAsciiTree();

        System.out.println();

        stringSearchTree.traceSearch("date");
        stringSearchTree.traceSearch("dog");
        stringSearchTree.traceSearch("raspberry");
        stringSearchTree.traceSearch("yellow");

        System.out.println();

        stringSearchTree.printNodeBalances();

        System.out.println();

        System.out.println("Is AVL? " + stringSearchTree.isAVL());

        System.out.println();
        System.out.println();

        System.out.println("\nAVL Tree Structure (Integers):");
        integerSearchTree.printAsciiTree();

        System.out.println();

        integerSearchTree.traceSearch(71);
        integerSearchTree.traceSearch(28);
        integerSearchTree.traceSearch(1);
        integerSearchTree.traceSearch(100);

        System.out.println();

        integerSearchTree.printNodeBalances();

        System.out.println();

        System.out.println("Is AVL? " + integerSearchTree.isAVL());
    }
}
