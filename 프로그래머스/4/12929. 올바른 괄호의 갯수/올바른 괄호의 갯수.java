import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        answer = dp[n];
        return answer;
    }
}