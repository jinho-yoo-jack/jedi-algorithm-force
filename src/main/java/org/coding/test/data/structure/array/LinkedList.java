package org.coding.test.data.structure.array;

public class LinkedList<T> {
    public class Node {
        private final T data;
        private final int index;
        private Node next;

        public Node(T data, int index) {
            this.data = data;
            this.index = index;
            this.next = null;
        }

        public void setNext(Node next) {
            if (this.next == null) this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node newNode = new Node(data, size);
        if (this.head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T get(int index) {
        int currentIndex = 0;
        Node currentNode = head;
        while (true) {
            currentIndex = currentNode.index;
            if (currentIndex == index) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
    }

    public int size() {
        return size;
    }
}
