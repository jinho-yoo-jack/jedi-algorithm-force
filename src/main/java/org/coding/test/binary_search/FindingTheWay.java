package org.coding.test.binary_search;

import java.util.Arrays;

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

        int data_size = nodeinfo.length;

        int[][] sequencedData = new int[data_size][3];
        for (int i = 0; i < data_size; i++) {
            sequencedData[i][0] = nodeinfo[i][0];
            sequencedData[i][1] = nodeinfo[i][1];
            sequencedData[i][2] = i + 1;
        }

        Arrays.sort(sequencedData, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0]; // y좌표 값이 동일한 경우, x좌표 기준 ASC 정렬
            else return o2[1] - o1[1]; // y좌표 기준 DESC 정렬
        });
    }
}
