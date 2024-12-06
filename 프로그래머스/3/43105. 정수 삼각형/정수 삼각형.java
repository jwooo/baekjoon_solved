class Solution {
    
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        // given
        int y = triangle.length;
        int x = triangle[y - 1].length;
        
        dp = new int[y][x];
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        // when // then
        return recursion(0, 0, triangle.length, 0, triangle);
    }
    
    private int recursion(int nowY, int nowX, int length, int sum, int[][] triangle) {
        int nowNode = triangle[nowY][nowX];
        
        if (length <= 1) {
            return nowNode;
        } else {
            int left = dp[nowY + 1][nowX] != -1 
                ? dp[nowY + 1][nowX] 
                : recursion(nowY + 1, nowX, length - 1, sum + nowNode, triangle);
            
            int right = dp[nowY + 1][nowX + 1] != -1 
                ? dp[nowY + 1][nowX + 1] 
                : recursion(nowY + 1, nowX + 1, length - 1, sum + nowNode, triangle);
            
            dp[nowY][nowX] = nowNode + Math.max(left, right);
                
            return dp[nowY][nowX];
        }
    }
    
}