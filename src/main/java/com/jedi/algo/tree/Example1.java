package com.jedi.algo.tree;

import java.util.*;

public class Example1 {
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static Map<Integer, Integer> pathMap = new HashMap<>();
    static int[] target;
    static Set<Integer> leafNodes = new HashSet<>();
    static List<Integer> answer = null;
    static int maxDepth = 0;

    public static int[] solution(int[][] edges, int[] targetInput) {
        target = targetInput.clone();
        int n = target.length;

        // 트리 구성
        for (int i = 0; i < n; i++) leafNodes.add(i + 1);

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
            leafNodes.remove(parent);
        }

        for (int key : tree.keySet()) {
            Collections.sort(tree.get(key)); // 자식 노드 오름차순
            pathMap.put(key, 0); // 초기 길은 가장 왼쪽
        }

        dfs(new ArrayList<>(), targetInput.clone(), new HashMap<>(pathMap));
        return answer == null ? new int[]{-1} : answer.stream().mapToInt(i -> i).toArray();
    }

    static void dfs(List<Integer> sequence, int[] currentTarget, Map<Integer, Integer> currentPathMap) {
        if (answer != null && sequence.size() >= answer.size()) return;

        // 모든 리프 노드가 목표치 도달하면 정답 후보 저장
        boolean done = true;
        for (int leaf : leafNodes) {
            if (currentTarget[leaf - 1] != 0) {
                done = false;
                break;
            }
        }
        if (done) {
            answer = new ArrayList<>(sequence);
            return;
        }

        // 1,2,3 공 중에서 시도
        for (int ball = 1; ball <= 3; ball++) {
            int[] newTarget = currentTarget.clone();
            Map<Integer, Integer> newPath = new HashMap<>(currentPathMap);
            List<Integer> newSequence = new ArrayList<>(sequence);
            int node = 1;
            List<Integer> path = new ArrayList<>();

            // 공이 떨어지는 경로 추적
            while (tree.containsKey(node)) {
                path.add(node);
                List<Integer> children = tree.get(node);
                int idx = newPath.get(node);
                node = children.get(idx);
            }

            // 리프 노드 도착
            path.add(node);
            System.out.println("path: " + path);
            System.out.println("ball: " + ball);
            newTarget[node - 1] -= ball;
            if (newTarget[node - 1] < 0) continue;

            // 길 회전 (round-robin 방식)
            for (int i = 0; i < path.size() - 1; i++) {
                int curr = path.get(i);
                List<Integer> children = tree.get(curr);
                int idx = newPath.get(curr);
                idx = (idx + 1) % children.size();
                newPath.put(curr, idx);
            }

            newSequence.add(ball);
            System.out.println("newSequence: " + Arrays.toString(newSequence.stream().mapToInt(i -> i).toArray()));
            System.out.println("newTarget: " + Arrays.toString(newTarget));
            dfs(newSequence, newTarget, newPath);
        }
    }

    // 테스트
    public static void main(String[] args) {
        int[][] edges1 = {
                {2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7},
                {2, 5}, {3, 6}, {6, 10}, {6, 9}
        };
        int[] target1 = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        System.out.println(Arrays.toString(solution(edges1, target1)));
        // 출력: [1, 1, 2, 2, 2, 3, 3]
    }
}
