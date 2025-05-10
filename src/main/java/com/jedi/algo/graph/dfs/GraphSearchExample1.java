package com.jedi.algo.graph.dfs;

import java.util.*;

public class GraphSearchExample1 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void dfs(int v) {
        visited[v] = true;
        for(int friend : graph.get(v)) {
            if(!visited[friend]) {
                count++;
                dfs(friend);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int allStudents = scanner.nextInt();
        System.out.println(allStudents);
        int relationshipCount = scanner.nextInt();
        System.out.println(relationshipCount);

        for(int i = 0; i < allStudents + 1; i++) graph.add(new ArrayList<>());
        visited = new boolean[allStudents + 1];

        for(int i = 0; i < relationshipCount; i++) {
            int s1 = scanner.nextInt();
            int s2 = scanner.nextInt();
            graph.get(s1).add(s2);
            graph.get(s2).add(s1);
        }

        int start = scanner.nextInt();
        dfs(start);
        System.out.println(count);
    }
}
