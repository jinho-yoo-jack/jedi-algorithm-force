package com.jedi.algo.graph.dfs;

import java.util.*;

public class GraphSearchExample {
    static int[][] maze = {
        {0, 1, 0, 0, 0}, // 0
        {0, 1, 0, 1, 0}, // 1
        {0, 0, 0, 1, 0}, // 2
        {0, 0, 0, 1, 0}, // 3
        {1, 1, 0, 1, 0}, // 4
        {0, 0, 0, 0, 0}, // 5
    };
    static int rowSize = maze.length;
    static int colsSize = maze[0].length;

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

        @Override
        public String toString() {
            return " (" + x + ", " + y + ") ";

        }
    }

    static int[][] graph;
    static List<List<Node>> paths = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void findAllPaths(Node startPoint, Node destPoint) {
        boolean[][] visited = new boolean[rowSize][colsSize];
        List<Node> stack = new ArrayList<>();
        dfs(startPoint, destPoint, visited, stack);
    }

    static void dfs(Node current, Node dest, boolean[][] visited, List<Node> path) {
        visited[current.x][current.y] = true;
        path.add(current);

        if (current.getX() == dest.getX() && current.getY() == dest.getY())
            System.out.println(Arrays.toString(path.toArray()));
        else {
            for (int i = 0; i < dx.length; i++) {
                int nextX = current.getX() + dx[i];
                int nextY = current.getY() + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < rowSize && nextY < colsSize)
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == 0)
                        dfs(new Node(nextX, nextY), dest, visited, path);
            }
        }

        path.remove(path.size() - 1);
        visited[current.x][current.y] = false;
    }

    public static void main(String[] args) {
        findAllPaths(new Node(0, 0), new Node(5, 4));
    }
}