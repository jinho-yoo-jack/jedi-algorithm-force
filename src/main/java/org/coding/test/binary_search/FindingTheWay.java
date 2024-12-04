package org.coding.test.binary_search;

import java.util.*;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/42892?language=java
public class FindingTheWay {
    public static class Node {
        private int x;
        private int y;
        private int index;
        private Node left;
        private Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getIndex() {
            return index;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static void insert(Node parent, Node child) {
        if (child.getX() < parent.getX()) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
            } else {
                insert(parent.getLeft(), child);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(child);
            } else {
                insert(parent.getRight(), child);
            }
        }
    }

    public static void preOrder2(Node searchingNode, List<Integer> searchedNodes) {
        if (searchingNode != null) {
            searchedNodes.add(searchingNode.index);
            preOrder2(searchingNode.left, searchedNodes);
            preOrder2(searchingNode.right, searchedNodes);
        }
    }

    public static void postOrder(Node searchingNode, List<Integer> searchedNodes) {
        if (searchingNode != null) {
            postOrder(searchingNode.left, searchedNodes);
            postOrder(searchingNode.right, searchedNodes);
            searchedNodes.add(searchingNode.index);
        }
    }





    public static void main(String[] args) {
        int[][] nodeinfo = new int[][]{
            {5, 3}, // 0
            {11, 5},// 1
            {13, 3},// 2
            {3, 5}, // 3
            {6, 1}, // 4
            {1, 3}, // 5
            {8, 6}, // 6
            {7, 2}, // 7
            {2, 2}}; // 8

        PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> {
            if (o1.y == o2.y) return o1.x - o2.x;
            else return o2.y - o1.y;
        });
        IntStream.range(0, nodeinfo.length)
            .forEach(i -> {
                nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
            });

        nodes.forEach(node -> {
            System.out.println("x:" + node.x + ", y:" + node.y);
        });

        Node root = nodes.poll();
        while (!nodes.isEmpty()) {
            Objects.requireNonNull(root);
            insert(root, nodes.poll());
        }

        List<Integer> searchedNodes = new ArrayList<>();
        preOrder2(root, searchedNodes);
        List<Integer> postSearchedNodes = new ArrayList<>();
        postOrder(root, postSearchedNodes);
        searchedNodes.forEach(node -> System.out.print(node + ","));


    }
}
