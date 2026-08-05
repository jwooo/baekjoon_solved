import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int[] item : info) {
            int costA = item[0];
            int costB = item[1];
            
            int[] nextDp = new int[n];
            Arrays.fill(nextDp, Integer.MAX_VALUE);
            
            for (int a = 0; a < n; a++) {
                if (dp[a] == Integer.MAX_VALUE || dp[a] >= m) continue;
                
                int nextA = a + costA;
                if (nextA < n) {
                    nextDp[nextA] = Math.min(nextDp[nextA], dp[a]);
                }
                
                int nextB = dp[a] + costB;
                if (nextB < m) {
                    nextDp[a] = Math.min(nextDp[a], nextB);
                }
            }
            
            dp = nextDp;
        }

        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            if (dp[a] < m) {
                answer = Math.min(answer, a);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}