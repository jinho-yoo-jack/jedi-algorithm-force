package com.jedi.algo.graph.tree;

import java.util.*;

public class Example1 {
    static class Node {
        int value;
        Node left, right, middle;

        public Node(int value) {
            this.value = value;
            left = right = middle = null;
        }
    }
    static int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
    static Map<Integer, Node> nodeMap = new HashMap<>();
    static Set<Integer> childNodes = new HashSet<>();


    public static void main(String[] args) {
        for (int[] edge : edges) {
            int parentVal = edge[0];
            int childVal = edge[1];

            Node parent = nodeMap.computeIfAbsent(parentVal, Node::new);
            Node child = nodeMap.computeIfAbsent(childVal, Node::new);

            childNodes.add(childVal);

            // 왼쪽 자식 먼저 채우고, 없으면 오른쪽
            if (parent.left == null) parent.left = child;
            else if (parent.right == null) parent.right = child;
        }
        /*
        Node root = new Node();
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Queue<List<Integer>> makePathQueue = new LinkedList<>();
        Queue<List<Integer>> paths = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            if (!map.containsKey(parent)) {
                Queue<Integer> childs = new PriorityQueue<>();
                childs.add(child);
                map.put(parent, childs);
            } else map.get(parent).add(child);
        }

        System.out.println(map);
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            while (!entry.getValue().isEmpty()) {
                int k = entry.getKey();
                int v = entry.getValue().poll();
                if(k == 1) {
                    root.value = v;
                    root.left = new Node();
                    root.left.value = v;
                }
            }

        }

        int twoDepthSize = map.get(1).size();
        for (int i = 0; i < twoDepthSize; i++) {
            int child = map.get(1).poll();
            List<Integer> path = new ArrayList<>();
            path.add(1);
            path.add(child);
            makePathQueue.add(path);
        }

        while (!makePathQueue.isEmpty()) {
            List<Integer> path = makePathQueue.poll(); //
            int last = path.get(path.size() - 1);
            if (!map.containsKey(last)){
                paths.add(path);
                if(path.get(1) == 2 && !map.get(2).isEmpty()) makePathQueue.add(new ArrayList<>(Arrays.asList(1,2)));
                else if(path.get(1) == 3 && !map.get(3).isEmpty()) makePathQueue.add(new ArrayList<>(Arrays.asList(1,)));
            }
            else {
                path.add(map.get(last).poll());
                makePathQueue.add(path);
            }
        }

        paths.forEach(System.out::println);
 */
    }
}
