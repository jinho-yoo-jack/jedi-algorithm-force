package com.jedi.testing.naver;

public class Solution3 {
    public static int gcd(int a, int b){
        int c = a % b;
        if (c == 0) {
            return b;
        }
        return gcd(b, c);
    }

    public static int solution() {
        int[] X = new int[]{1, 2, 3, 1, 2, 12, 8, 4};
        int[] Y = new int[]{5, 10, 15, 2, 4, 15, 10, 5};
        int count = 0;
        int[][] dp = new int[X.length][2];
        for (int i = 0; i < X.length; i++) {
            int gcdValue = gcd(X[i], Y[i]);
            if (gcdValue > 1) dp[i] = new int[]{X[i] / gcdValue, Y[i] / gcdValue};
            else dp[i] = new int[]{X[i], Y[i]};
        }

        for (int i = 0; i < dp.length; i++) {
            int parent = dp[i][1];
            int child = dp[i][0];
            for (int j = i + 1; j < Y.length; j++) {
                int nextParent = dp[j][1];
                int nextChild = dp[j][0];
                if (parent == nextParent && (child + nextChild == parent)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
