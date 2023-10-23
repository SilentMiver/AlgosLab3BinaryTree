import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
     E key;
     BinaryTree<E> left;
     BinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        sb.append(key).append("\n");
        if (left != null) {
            sb.append(left.asIndentedPreOrder(indent + 2));
        }
        if (right != null) {
            sb.append(right.asIndentedPreOrder(indent + 2));
        }
        return sb.toString();
    }
//     void addkey(StringBuilder sb, int indent){
//        if(sb.isEmpty()) sb.append(this.getKey());
//        else {
//            for (int i = 0; i < indent; i++) {
//                sb.append(" ");
//            }
//            sb.append(this.getKey());
//        }
//    }


    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    public List<AbstractBinaryTree<E>> depthFirstSearch() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            BinaryTree<E> node = stack.pop();
            result.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    public List<AbstractBinaryTree<E>> breadthFirstSearch() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            BinaryTree<E> node = queue.poll();
            result.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    @Override
    public String toString() {
//        return "BinaryTree{" +
//                "key=" + key +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
         return key.toString();
    }

}
