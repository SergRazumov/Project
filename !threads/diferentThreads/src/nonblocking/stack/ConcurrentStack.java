package nonblocking.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<E> {
    static class Node<E> {
        final E item;
        Node<E> next;

        public Node(E item) { this.item = item; }
    }

    AtomicReference<Node<E>> head = new AtomicReference<>();

    public void push1(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head.get();
        head.set(newNode);
    }

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = head.get();
            if (oldHead == null)
                return null;
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead,newHead));
        return oldHead.item;
    }

    public static void main(String[] args) {
        final ConcurrentStack<Integer> stack = new ConcurrentStack<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    stack.push(j);
                    stack.pop();
                }
            }));
        }
        threads.forEach(t -> t.start());
    }
}