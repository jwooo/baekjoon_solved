import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1_000_001];
        
        queue.offer(new int[]{x, 0});
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 3; i++) {
                int calcNow = calculate(i, n, now[0]);
                
                if (calcNow <= y && !visited[calcNow]) {
                    if (calcNow == y) return now[1] + 1;
                    
                    visited[calcNow] = true;
                    queue.offer(new int[]{calcNow, now[1] + 1});
                }
            }
        }
        
        return -1;
    }
    
    private int calculate(int i, int n, int now) {
        if (i == 0) return now + n;
        else if (i == 1) return now * 2;
        else return now * 3;
    }
    
}