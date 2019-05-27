import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<Map.Entry<K, V>> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Node<K, V> root;

    public V get(K key) {
        return getRec(key, root);
    }

    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private Node<K, V> put(K key, V value, Node<K, V> node) {
        if (node == null) return new Node<>(key, value);
        int comp = key.compareTo(node.key);
        if (comp < 0) node.left = put(key, value, node.left);
        else if (comp > 0) node.right = put(key, value, node.right);
        else {
            node.value = value;
        }
        return node;
    }

    public void add(K key, V value) {
        if (root == null) root = new Node<>(key, value); else add(key, value, root);
    }

    public void add(K key, V value, Node<K, V> node) {
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            node.value = value;
        } else if (comp < 0 && node.left == null) {
            node.left = new Node<>(key, value);
        } else if (comp > 0 && node.right == null) {
            node.right = new Node<>(key, value);
        } else if (comp < 0) {
            add(key, value, node.left);
        } else {
            add(key, value, node.right);
        }
    }

    public void remove(K key) { root = remove(key, root); }

    //TODO: дописать случай с двумя наследниками.

    private Node<K,V> remove(K key, Node<K,V> node) {
        if(node == null) return null;
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } else {
                Node <K,V> node1 = maxNode(node.left);
                node.key = node1.key;
                node.value = node1.value;
                node.left = remove(node1.key, node.left);
            }
        } else if (comp < 0) { node.left = remove(key, node.left); }
        else { node.right = remove(key, node.right); }
        return node;
    }

    private Node<K,V> maxNode(Node<K,V> node) {
        if(node.right == null) return node;
        return maxNode(node.right);
    }

    private V getRec(K key, Node<K, V> node) {
        if (node == null) return null;
        int comp = key.compareTo(node.key);
        if (comp == 0) return node.value;
        return comp < 0 ? getRec(key, node.left) : getRec(key, node.right);
    }

    public V get1(K key) {
        Node<K, V> node = root;
        while (node != null) {
            int comp = key.compareTo(node.key);
            if (comp == 0) return node.value;
            node = comp < 0 ? node.left : node.right;
        }
        return null;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {

        return new Iterator<Map.Entry<K, V>>() {
            Stack<Node<K, V>> stack = new Stack<>();
            Node<K, V> current = root == null ? null : goLeft(root);


            private Node<K, V> goLeft(Node<K, V> node) {
                while (node.left != null) {
                    stack.push(node);
                    node = node.left;
                }
                return node;
            }

            @Override
            public boolean hasNext() {
                return current!= null;
            }

            @Override
            public Map.Entry<K, V> next() {
                Node<K,V> start = current;
                if(current == null) throw new IllegalStateException();
                if(current.right == null && !stack.isEmpty()) current = stack.pop();
                else if(current.right != null) current = goLeft(current.right);
                else current = null;
                return new AbstractMap.SimpleEntry<K,V>(start.key, start.value);
            }
        };
    }

    public V maxValue() {
        Node<K,V> current= root;
        if (root == null) return null;
        while(current.right!= null) {
            current = current.right;
        }
        return current.value;
    }

    public static void main(String[] args) {
        BST<String, String> tree = new BST<>();
        tree.put("one", "1");
        tree.put("two", "2");
        tree.put("three", "3");
        tree.put("four", "4");
        tree.put("five", "5");
        tree.put("six", "6");
        tree.put("seven", "7");
        tree.put("eight", "8");
        tree.put("nine", "9");
        tree.put("ten", "10");
        System.out.println(tree.get("nine"));
        for (Map.Entry<String, String> v : tree) {
            System.out.print("(" + v.getKey() + ", " + v.getValue() + ") ");
        }
        System.out.println();
        System.out.println(tree.maxValue());
        tree.remove("four1");
        for (Map.Entry<String, String> v : tree) {
            System.out.print("(" + v.getKey() + ", " + v.getValue() + ") ");
        }
    }
}
