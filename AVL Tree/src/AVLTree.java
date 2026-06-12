public class AVLTree<E extends Comparable<E>> {


    private AVLNode<E> root;

    public void insert(E element) {
        root = insert(root, element);
    }

    private AVLNode<E> insert(AVLNode<E> node, E element) {
        if (node == null) {
            return new AVLNode<>(element);
        }

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = insert(node.left, element);
        } else if (cmp > 0) {
            node.right = insert(node.right, element);
        } else {
            return node; // Duplicate keys not allowed
        }

        updateHeight(node);
        return balance(node);
    }

    public void delete(E element) {
        root = delete(root, element);
    }

    private AVLNode<E> delete(AVLNode<E> node, E element) {
        if (node == null) return null;

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = delete(node.left, element);
        } else if (cmp > 0) {
            node.right = delete(node.right, element);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                AVLNode<E> minNode = findMin(node.right);
                node.element = minNode.element;
                node.right = delete(node.right, minNode.element);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    private AVLNode<E> findMin(AVLNode<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private int height(AVLNode<E> node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(AVLNode<E> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int balanceFactor(AVLNode<E> node) {
        return height(node.right) - height(node.left);
    }

    private AVLNode<E> balance(AVLNode<E> node) {
        int bf = balanceFactor(node);

        if (bf == -2) {
            if (balanceFactor(node.left) <= 0) {
                return rotateRight(node); // LL
            } else {
                node.left = rotateLeft(node.left); // LR
                return rotateRight(node);
            }
        } else if (bf == 2) {
            if (balanceFactor(node.right) >= 0) {
                return rotateLeft(node); // RR
            } else {
                node.right = rotateRight(node.right); // RL
                return rotateLeft(node);
            }
        }

        return node; // already balanced
    }

    private AVLNode<E> rotateLeft(AVLNode<E> a) {
        AVLNode<E> b = a.right;
        a.right = b.left;
        b.left = a;
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    private AVLNode<E> rotateRight(AVLNode<E> a) {
        AVLNode<E> b = a.left;
        a.left = b.right;
        b.right = a;
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    public void printAsciiTree() {
        printAsciiTree(root, " ",false);
    }

    private void printAsciiTree(AVLNode<E> node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.element);

        if (node.left != null || node.right != null) {
            if (node.right != null) {
                printAsciiTree(node.right, prefix + (isTail ? "    " : "│   "), false);
            }
            if (node.left != null) {
                printAsciiTree(node.left, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public boolean traceSearch(E key) {
        System.out.println("Searching for " + key + "...");
        System.out.print("Visited: ");
        return traceSearchHelper(key, root);
    }

    private boolean traceSearchHelper(E key, AVLNode<E> node) {
        if (node == null) {
            System.out.println("not found");
            return false;
        }

        int diff = key.compareTo(node.element);

        if (diff == 0) {
            System.out.println(node.element + " (found)");
            return true;
        } else if (diff > 0) {
            System.out.print(node.element + " -> ");
            return traceSearchHelper(key, node.right);
        } else {
            System.out.print(node.element + " -> ");
            return traceSearchHelper(key, node.left);
        }
    }
}

