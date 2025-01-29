import java.util.*;

class Solution {
    
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length + 1][4];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], land[i][j] + dp[i][k]);
                        answer = Math.max(answer, dp[i + 1][j]);
                    }
                }
            }
        }
        
        return answer;
    }
}