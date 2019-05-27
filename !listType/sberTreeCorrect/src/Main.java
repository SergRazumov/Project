import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
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
        Main a = new Main();
        Map<Integer, Treenode> tree = a.addNodeTree(nodes);
        a.buildGraphicalTree(tree, nodes);


    }

    private static class Node {
        private int id;
        private String name;
        private int parentId;

        public Node(int id, String name, int parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getParentId() {
            return parentId;
        }
    }

    public class Treenode {
        private  List<Treenode> node;
        private String name;

        public Treenode(ArrayList<Treenode> node, String name) {
            this.node = node;
            this.name = name;
        }
    }

    private Map<Integer, Treenode> addNodeTree(Node[] nodes) {
        Map<Integer, Treenode> tree = new HashMap<Integer, Treenode>();
        for(int i =0; i<nodes.length; i++) {
            tree.put(nodes[i].getId(),new Treenode(new ArrayList<Treenode>(),nodes[i].getName()));
        }
        for(Node n:nodes) {
            if (n.parentId != -1) {
               Treenode ex = tree.get(n.parentId);
               ex.node.add(tree.get(n.id));
            }
        }
        return tree;
    }

//TODO: может еще имеет смысл сформировать список из Parent и отсортировать их по "имени" чтобы Parent шли по порядку
    public void buildGraphicalTree(Map<Integer, Treenode> tree, Node[] nodes) {
        for(Node n:nodes) {
            if (n.parentId == -1) {
                Treenode ex = tree.get(n.getId());
                buildGraphicalTree(ex, "");
            }
        }
    }

    private void buildGraphicalTree(Treenode treeNode, String prefix) {
        System.out.println("{ "+ prefix + treeNode.name + " }");
        for(Treenode n:treeNode.node) {
                buildGraphicalTree(n,prefix + "- ");
            }
        }
    }



