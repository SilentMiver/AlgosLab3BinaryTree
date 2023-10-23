import java.util.List;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(4);
        tree.left = new BinaryTree<>(2);
        tree.right = new BinaryTree<>(6);
//        System.out.println(" Test left + right: " + tree.toString() );
        tree.left.left = new BinaryTree<>(1);
        tree.left.right = new BinaryTree<>(3);
        System.out.println(" Test left + right: \n" + tree.asIndentedPreOrder(5));
        tree.right.left = new BinaryTree<>(5);
        tree.right.right = new BinaryTree<>(7);

        System.out.println("Indented PreOrder:");
        System.out.println(tree.asIndentedPreOrder(0));

        System.out.println("PreOrder:");
        System.out.println(tree.preOrder());

        System.out.println("InOrder:");
        System.out.println(tree.inOrder());

        System.out.println("PostOrder:");
        System.out.println(tree.postOrder());

        System.out.println("InOrder using forEachInOrder:");
        tree.forEachInOrder(System.out::print);
        // Создаем бинарное дерево
//        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
//        tree1.left = new BinaryTree<>(2);
//        tree1.right = new BinaryTree<>(3);
//        tree1.left.left = new BinaryTree<>(4);
//        tree1.left.right = new BinaryTree<>(5);
//        tree1.right.left = new BinaryTree<>(6);
//        tree1.right.right = new BinaryTree<>(7);

        // V glubinu
        System.out.println("\nDepth-First Traversal:");
        List<AbstractBinaryTree<Integer>> depthFirstResult = tree.depthFirstSearch();
        depthFirstResult.forEach(node -> System.out.print(node.getKey() + " "));

        // v shirinu
        System.out.println("\nBreadth-First Traversal:");
        List<AbstractBinaryTree<Integer>> breadthFirstResult = tree.breadthFirstSearch();
        breadthFirstResult.forEach(node -> System.out.print(node.getKey() + " "));
    }
}