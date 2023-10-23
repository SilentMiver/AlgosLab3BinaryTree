public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            return new Node<>(element);
        }

        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }

        return root;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }

    private boolean containsRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }

        int cmp = element.compareTo(root.value);
        if (cmp < 0) {
            return containsRec(root.leftChild, element);
        } else if (cmp > 0) {
            return containsRec(root.rightChild, element);
        } else {
            return true;
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        return searchRec(root, element);
    }

    private AbstractBinarySearchTree<E> searchRec(Node<E> root, E element) {
        if (root == null) {
            return new BinarySearchTree<>();
        }

        int cmp = element.compareTo(root.value);
        if (cmp < 0) {
            return searchRec(root.leftChild, element);
        } else if (cmp > 0) {
            return searchRec(root.rightChild, element);
        } else {
            BinarySearchTree<E> result = new BinarySearchTree<>();
            result.root = root;
            return result;
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root != null) {
            BinarySearchTree<E> leftTree = new BinarySearchTree<>();
            leftTree.root = root.leftChild;
            return leftTree.getRoot();
        }
        return null;
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            BinarySearchTree<E> rightTree = new BinarySearchTree<>();
            rightTree.root = root.rightChild;
            return rightTree.getRoot();
        }
        return null;
    }

    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    // Метод для создания зеркального изображения дерева
    public BinarySearchTree<E> mirror() {
        BinarySearchTree<E> mirroredTree = new BinarySearchTree<>();
        mirroredTree.root = mirrorRec(root);
        return mirroredTree;
    }

    private Node<E> mirrorRec(Node<E> root) {
        if (root == null) {
            return null;
        }

        Node<E> mirrored = new Node<>(root.value);
        mirrored.leftChild = mirrorRec(root.rightChild);
        mirrored.rightChild = mirrorRec(root.leftChild);
        return mirrored;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
