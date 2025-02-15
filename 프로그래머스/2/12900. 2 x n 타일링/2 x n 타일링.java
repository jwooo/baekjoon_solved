import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        int divideNumber = 1_000_000_007;
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % divideNumber + dp[i - 2] % divideNumber;
        }
        
        answer = dp[n] % divideNumber;
        return answer;
    }
}