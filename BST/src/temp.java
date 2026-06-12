        
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


    