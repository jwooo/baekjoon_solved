class Solution {
    static int N, M, K;
    static int targetX, targetY;
    static String answer = "impossible";
    static boolean found = false;
    static int[][] directions = {
        {1, 0}, 
        {0, -1},
        {0, 1}, 
        {-1, 0}
    };
    static char[] dirChars = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;
        targetX = r;
        targetY = c;
        
        dfs(x, y, 0, new StringBuilder());
        return answer;
    }
    
    private void dfs(int curX, int curY, int depth, StringBuilder path) {
        if (found) return;
        
        int dist = Math.abs(targetX - curX)  + Math.abs(targetY - curY);
        if (dist > K - depth) return;
        if ((K - depth - dist) % 2 != 0) return;
        
        if (depth == K) {
            if (curX == targetX && curY == targetY) {
                answer = path.toString();
                found = true;
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nowX = curX + directions[i][0];
            int nowY = curY + directions[i][1];
            
            if (nowX < 1 || nowY < 1 || nowX > N || nowY > M) continue;
            
            path.append(dirChars[i]);
            dfs(nowX, nowY, depth + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}