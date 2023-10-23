public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        System.out.println("Original Tree:");
        System.out.println("Contains 4: " + bst.contains(4)); //  true
        System.out.println("Contains 6: " + bst.contains(6)); //  false
        System.out.println(bst.toString());

        System.out.println("Mirror Tree:");
        var mirroredTree = bst.mirror();
        System.out.println(mirroredTree.toString());

    }
}
