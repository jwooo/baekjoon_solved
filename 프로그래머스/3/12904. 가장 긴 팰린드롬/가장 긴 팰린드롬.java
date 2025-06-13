class Solution {
    public int solution(String s) {
        int n = s.length();
        
        if (n <= 1) return n;
        
        boolean[][] dp = new boolean[n][n];
        
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        } 
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                
                if (2 > maxLength) {
                    maxLength = 2;
                }
            }
        }
        
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                 
                   	maxLength = Math.max(maxLength, length);
                }
            }
        }
        
        return maxLength;
    }
}