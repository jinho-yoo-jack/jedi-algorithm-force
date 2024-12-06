package org.coding.test.binary_search;

import java.util.*;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/42892?language=java
public class FindingTheWay {
    public static class BinaryTreeNode {
        private Node root;
        private PriorityQueue<Node> orderedNodes;

        public void makeNodeOrderByXY(int[][] nodeInfo) {
            List<Node.Data> datum = makeData(nodeInfo);
            PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> {
                if (o1.getY() == o2.getY()) return o1.getX() - o2.getX();
                else return o2.getY() - o1.getY();
            });
            IntStream.range(0, datum.size())
                    .forEach(i -> {
                        nodes.add(new Node(datum.get(i)));
                    });
            this.orderedNodes = nodes;
        }

        public void makeBinaryTree() {
            if (root == null) setRoot(this.orderedNodes.poll());
            while (!orderedNodes.isEmpty()) {
                insert(root, orderedNodes.poll());
            }
        }

        private boolean setRoot(Node root) {
            Objects.requireNonNull(root);
            if (this.root == null) this.root = root;
            else return false;
            return true;
        }

        private List<Node.Data> makeData(int[][] nodeInfo) {
            List<Node.Data> datum = new ArrayList<>();
            for (int i = 0; i < nodeInfo.length; i++) {
                datum.add(new Node.Data(nodeInfo[i][0], nodeInfo[i][1], i + 1));
            }
            return datum;
        }

        private void insert(Node parent, Node child) {
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

        public void preOrder2(Node searchingNode, List<Integer> searchedNodes) {
            if (searchingNode == null && searchedNodes.isEmpty()) searchingNode = this.root;
            if (searchingNode != null) {
                searchedNodes.add(searchingNode.getIndex());
                preOrder2(searchingNode.getLeft(), searchedNodes);
                preOrder2(searchingNode.getRight(), searchedNodes);
            }
        }

        public void postOrder(Node searchingNode, List<Integer> searchedNodes) {
            if (searchingNode == null && searchedNodes.isEmpty()) searchingNode = this.root;
            if (searchingNode != null) {
                postOrder(searchingNode.getLeft(), searchedNodes);
                postOrder(searchingNode.getRight(), searchedNodes);
                searchedNodes.add(searchingNode.getIndex());
            }
        }
    }

    public static class Node {
        public static class Data {
            private int x;
            private int y;
            private int index;

            public Data(int x, int y, int index) {
                this.x = x;
                this.y = y;
                this.index = index;
            }
        }

        private Data data;
        private Node left;
        private Node right;

        public Node(Data data) {
            this.data = data;
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
            return data.x;
        }

        public int getY() {
            return data.y;
        }

        public int getIndex() {
            return data.index;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
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

        BinaryTreeNode tree = new BinaryTreeNode();
        tree.makeNodeOrderByXY(nodeinfo);
        tree.makeBinaryTree();

        List<Integer> searchedNodes = new ArrayList<>();
        tree.preOrder2(null, searchedNodes);
        searchedNodes.forEach(node -> System.out.print(node + ","));
//        List<Integer> postSearchedNodes = new ArrayList<>();
//        tree.postOrder(null, postSearchedNodes);

    }
}
