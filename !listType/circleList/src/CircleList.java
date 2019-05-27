public class CircleList {

    private int elements;

    private static class Element {
        int info;
        Element next;

        private Element(int info, Element next) {
            this.info = info;
            this.next = next;
        }
    }


    Element last = null;
    Element first = null;


    public void add(int a) {
        elements++;
        Element newElement = new Element(a, last);
        last = newElement;

        if (elements > 1) {
            first.next = last;
            check();
        } else {
            first = newElement;
        }
    }

    public int size() {
        return elements;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Element current = last; current != first; current = current.next) {
            sb.append(current.info);
            if (current.next != first.next) {
                sb.append(", ");
            }
        }
        sb.append(first.info + "]");
        return sb.toString();
    }

    public void reverse() {
        Element current = last;
        Element newList = null;

        while (current.next != null) {
            Element next = current.next;
            current.next = newList;
            newList = current;
            current = next;
        }
        current.next = newList;
        last = newList;
        first = current;
        check();
        }

    private void check() {
        if (first.next != last) throw new MyException("Список не кольцевой");
    }



}
