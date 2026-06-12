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
            50, 25, 75, 12, 37,
            62, 87, 6, 18, 31,
            43, 56, 68, 81, 93,
            3, 9, 15, 21, 28,
            34, 40, 46, 53, 59,
            65, 71, 78, 84, 90,
            96, 99
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

        System.out.println("\nAVL Tree Structure (Integers):");
        integerSearchTree.printAsciiTree();

        integerSearchTree.traceSearch(71);
        integerSearchTree.traceSearch(28);
        integerSearchTree.traceSearch(1);
        integerSearchTree.traceSearch(100);
    }
}
