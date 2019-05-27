import java.util.*;

public class BinTree<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    private static class Node<T> {
        T info;
        Node<T> child, brother;

        Node(T info) {
            this.info = info;
        }
    }

    private class TreeIterator implements Iterator<T> {
        private Node<T> currentNode = root;
        Queue<Node<T>> waitList = new LinkedList<>();

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node<T> cur = currentNode;


            if (currentNode.brother != null) {
                waitList.offer(currentNode.brother);
            }
            if (currentNode.child != null) {
                currentNode = currentNode.child;
            } else if (waitList.isEmpty()) {
                currentNode = null;
            } else {
                currentNode = waitList.poll();
            }
            return cur.info;
        }
    }

    Node<T> root;

    public int count() {
        return count(root);
    }
    public int count1() {return count1(root);}

    public int height() { return height(root); }

    private int height(Node<T> node) {
        if (node == null) return 0;
        int h = 0;
        for (Node<T> child = node.child; child != null; child = child.brother) {
            h = Math.max(h, height(child));
        }
        return h +1;
    }


    private int count(Node<T> root) {
        int sum = 0;
        if(root == null) return 0;
        sum = count(root.child);
        sum += count(root.brother);
        return sum+1;
    }

    private int count1(Node<T> root) {
        if (root == null) return 0;
        int sum =1;
        for(Node<T> child = root.child; child != null; child = child.brother) {
            sum += count1(child);
        }
        return sum;
    }

    public static void main(String[] args) {
        BinTree<String> tree = new BinTree();

        Node<String> level0 = new Node<>("Level 0");
        Node<String> level11 = new Node<>("Level 1-1");
        Node<String> level12 = new Node<>("Level 1-2");
        Node<String> level13 = new Node<>("Level 1-3");
        Node<String> level21 = new Node<>("Level 2-1");
        Node<String> level22 = new Node<>("Level 2-2");
        Node<String> level23 = new Node<>("Level 2-3");
        Node<String> level24 = new Node<>("Level 2-4");
        Node<String> level25 = new Node<>("Level 2-5");
        Node<String> level31 = new Node<>("Level 3-1");

        level0.child = level11;
        level11.brother = level12;
        level12.brother = level13;
        level11.child = level21;
        level21.brother = level22;
        level13.child = level23;
        level23.brother = level24;
        level24.brother = level25;
        level21.child = level31;

        tree.root = level0;

        for (String name : tree) {
            System.out.println(name);
        }

    }
}
