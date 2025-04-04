class Solution {
    public int solution(int n) {
    	int[] dp = new int[1_000_001];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }
        
        return dp[n] % 1234567;
    }
}