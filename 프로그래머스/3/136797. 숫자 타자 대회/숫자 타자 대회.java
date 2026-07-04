import java.util.*;

class Solution {
    
    int[][] cost = {
            {1,7,6,7,5,4,5,3,2,3},
            {7,1,2,4,2,3,5,4,5,6},
            {6,2,1,2,3,2,3,5,4,5},
            {7,4,2,1,5,3,2,6,5,4},
            {5,2,3,5,1,2,4,2,3,5},
            {4,3,2,3,2,1,2,3,2,3},
            {5,5,3,2,4,2,1,5,3,2},
            {3,4,5,6,2,3,5,1,2,4},
            {2,5,4,5,3,2,3,2,1,2},
            {3,6,5,4,5,3,2,4,2,1}
    };

    int[][][] dp;
    String numbers;
    int n;

    public int solution(String numbers) {

        this.numbers = numbers;
        this.n = numbers.length();

        dp = new int[n][10][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 4, 6);
    }

    private int dfs(int idx, int left, int right) {

        if (idx == n) return 0;

        if (dp[idx][left][right] != -1)
            return dp[idx][left][right];

        int target = numbers.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;

        if (target != right) {
            ans = Math.min(ans,
                    cost[left][target] + dfs(idx + 1, target, right));
        }

        if (target != left) {
            ans = Math.min(ans,
                    cost[right][target] + dfs(idx + 1, left, target));
        }

        return dp[idx][left][right] = ans;
    }
}