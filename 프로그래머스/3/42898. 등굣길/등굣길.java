class Solution {
    
    static long MOD = 1_000_000_007L;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        
        
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] != -1) {
                    int top = dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                    int left = dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;
                 
                    dp[i][j] = (int) (((top % MOD) + (left % MOD)) % MOD); 
                }
            }
        }
        
        return dp[n][m];
    }
}