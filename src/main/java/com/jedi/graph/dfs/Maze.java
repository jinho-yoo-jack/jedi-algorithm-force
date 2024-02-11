package com.jedi.graph.dfs;

public class Maze {
    /*
     * DFS 깊이 우선 탐색
     * 임의의 시작 노드에서 출발하여 한쪽 분리(방향)를 정해서 최대 깊이까지 탐색을 마친 후,
     * 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘
     * START_POINT = (0, 0)
     * END_POINT = (7, 7)
     * 벽 -> 1
     * 통로 -> 0
     * S 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 0 0 0 1
     * 1 1 0 1 1 0 0
     * 1 0 0 0 0 0 0
     * */
    static int[] dx = {0, 0, -1, 1}; // x는 상, 하로 움직 인다.
    static int[] dy = {-1, 1, 0, 0}; // y는 좌, 우로 움직 인다.
    static int cnt = 0;

    static void dfs(int[][] board, boolean[][] visited, int x, int y){
        boolean[][] tmp = visited.clone();
        if(x == 6 && y == 6){
            System.out.println("cnt");
            cnt += 1;
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if(move_x >= 0 && move_y >= 0 && move_x < board.length && move_y < board.length){
                if(!visited[move_x][move_y] && board[move_x][move_y] == 0){
                    dfs(board, visited, move_x, move_y);
                    visited[move_x][move_y] = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0}

        };
        boolean[][] visited = new boolean[7][7];
        dfs(board, visited, 0, 0);
        System.out.println("CNT => "+cnt);
    }

}
