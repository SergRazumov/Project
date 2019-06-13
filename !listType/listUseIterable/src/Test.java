import java.util.Iterator;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 public class Test implements Iterable {


        private static class Node {
            int id;
            String name;
            int parentId;
            Node child, brother;

            public Node(int id, String name, int parentId) {
                this.id = id;
                this.name = name;
                this.parentId = parentId;
            }
        }

        public Iterator iterator() {
            return new TreeIterator();
        }

        private class TreeIterator implements Iterator {
            private Node currentNode = root;
            Stack<Node> waitList = new Stack<>();

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public String next() {
                Node cur = currentNode;
                if (currentNode.brother != null) {
                    waitList.push(currentNode.brother);
                }
                if (currentNode.child != null) {
                    currentNode = currentNode.child;
                } else if (waitList.isEmpty()) {
                    currentNode = null;
                } else {
                    currentNode = waitList.pop();
                }
                return cur.name;
            }
        }

        Node root;


        public static void main(String[] args) {
            Node[] nodes = {
                    new Node(1, "Parent1", -1),
                    new Node(11, "Child1-1", 1),
                    new Node(12, "Child1-2", 1),
                    new Node(13, "SubParent1-1", 1),
                    new Node(131, "Child1-1-1", 13),
                    new Node(132, "Child1-1-2", 13),
                    new Node(21, "Child2-1", 2),
                    new Node(3, "Parent3", -1),
                    new Node(2000, "Child2-2", 2),
                    new Node(400, "Child2-3", 2),
                    new Node(2, "Parent2", -1),
            };
            Test test = new Test();

            nodes[0].brother = nodes[10];
            nodes[10].brother = nodes[7];
            nodes[0].child = nodes[3];
            nodes[3].child = nodes[4];
            nodes[4].brother = nodes[5];
            nodes[3].brother = nodes[1];
            nodes[1].brother = nodes[2];
            nodes[10].child = nodes[6];
            nodes[6].brother = nodes[8];
            nodes[8].brother = nodes[9];
            test.root = nodes[0];


            for (Object name : test) {
                System.out.println(name);
            }
            System.out.println();
        }
    }


