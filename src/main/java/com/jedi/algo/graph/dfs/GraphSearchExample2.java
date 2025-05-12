package com.jedi.algo.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class GraphSearchExample2 {
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    static void dfs(int current, int dest, boolean[] visited) {
        visited[current] = true;
        path.add(current);

        if (current == dest) System.out.println(path);
        else {
            for (int nextNode : graph.get(current)) {
                if (!visited[nextNode]) {
                    dfs(nextNode, dest, visited);
                }
            }
        }

        visited[current] = false;
        path.remove(path.size() - 1);
    }

    static void addEdge(int source, int dest) {
        graph.get(source).add(dest);
        graph.get(dest).add(source);
    }

    public static void main(String[] args) {
        int allNode = 6;
        int dest = 3;
        for (int i = 0; i <= allNode; i++) graph.add(new ArrayList<>());

        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(2, 5);
        addEdge(3, 6);
        addEdge(4, 5);
        addEdge(5, 6);

        boolean[] visited = new boolean[allNode + 1];
        dfs(1, dest, visited);


    }
}
