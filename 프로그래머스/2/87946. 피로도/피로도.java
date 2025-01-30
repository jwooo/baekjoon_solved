class Solution {
    
    private static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(visited.length, k, 0, visited, dungeons);
        
        return answer;
    }
    
    private void dfs(int depth, int now, int count, boolean[] visited, int[][] dungeons) {
        if (depth == 0) {
            answer = Math.max(answer, count);
            return;
        }
        
        for (int i = 0; i < visited.length; i++) {
            int[] nowDungeon = dungeons[i];
            
            if (!visited[i]) {
            	visited[i] = true;
                
                if (nowDungeon[0] <= now) {
                    dfs(depth - 1, now - nowDungeon[1], count + 1, visited, dungeons);
                } else {
                    dfs(depth - 1, now, count, visited, dungeons);
                }
                
                visited[i] = false;
            }
        }
    }
    
}