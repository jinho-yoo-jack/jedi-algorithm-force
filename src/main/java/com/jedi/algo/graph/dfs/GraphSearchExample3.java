package com.jedi.algo.graph.dfs;

import java.util.*;

public class GraphSearchExample3 {
    static class Node {
        private int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
    static int[][] graph;
    static List<List<Node>> paths = new ArrayList<>();
    static List<Node> currentPaths = new ArrayList<>();
    static Deque<Node> stack = new ArrayDeque<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(Node current, Node dest, boolean[][] visited) {
        visited[current.x][current.y] = true;
        currentPaths.add(current);

        if (current.getX() == dest.getX() && current.getY() == dest.getY()) System.out.println(currentPaths);
        else {
            // 1. 현재 경로(Current_Path)에서 갈 수 있는 길을 찾는다.
            // 2. 찾은 경로를 Stack에 저장한다.
            for (int i = 0; i < dx.length; i++) {
                int nextX = current.getX() + dx[i];
                int nextY = current.getY() + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) continue;
                else stack.push(new Node(nextX, nextY));
                assert stack.peek() != null;
                dfs(stack.peek(), dest, visited);
            }
        }

        visited[current.x][current.y] = false;
    }

    public static void main(String[] args) {
    }
}
