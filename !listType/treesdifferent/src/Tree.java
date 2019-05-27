import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 06.01.2019.
 */
public class Tree<T> {

    private static class Node<T> {
        T info;
        List<Node<T>> children;

        Node(T info) {
            this.info = info;
            children = new ArrayList<>();
        }
    }

    Node<T> root;

    public int count() {
        return count(root);
    }

    private int count(Node<T> node) {
        if (node == null) return 0;
        int sum = 1;
        for (Node<T> n : node.children) {
            sum += count(n);
        }
        return sum;
    }

    public int heightMax() {
        return heightMax(root);
    }

    private int heightMax(Node<T> root) {
        if (root == null) return 0;
        int employeesMax = 0;
        int sum = 0;
        for (Node<T> n : root.children) {
            sum = heightMax(n);
            if (sum > employeesMax) {
                employeesMax = sum;
            }
        }
        return employeesMax + 1;
    }

    public static void main(String[] args) {
        Node<String> dir = new Node<>("Dir");
        Node<String> zam1 = new Node<>("zam1");
        Node<String> zam2 = new Node<>("zam2");
        Node<String> zam3 = new Node<>("zam3");
        Node<String> subzam1 = new Node<>("subzam1");
        Node<String> sub1zam1 = new Node<>("sub1zam1");

        Tree<String> t = new Tree<>();
        t.root = dir;
        dir.children.add(zam1);
        dir.children.add(zam2);
        dir.children.add(zam3);
        zam1.children.add(subzam1);
        zam1.children.add(sub1zam1);
        System.out.println(t.count());
        System.out.println(t.heightMax());
    }
}





/*
public class List<T> {

    private static class Element<Tp> {
        Tp info;
        Element<Tp> next;

        Element(Tp value, Element<Tp> next) {
            info = value; this.next = next;
        }
    }

    private Element<T> first;

    void add(T value) {
        Element<T> newElement = new Element<>(value, first);
        first = newElement;
    }
}

 */