import java.util.*;

class Solution {
    
    static int[] oils;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        oils = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(j, i, land);
                }
            }
        }
        
        Arrays.sort(oils);
        return oils[oils.length - 1];
    }
    
    public void bfs(int x, int y, int[][] land) {
        int count = 1;
        
        visited[y][x] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        
        Set<Integer> set = new HashSet<>();
        set.add(x);
    
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                
                if (nowY < 0 || nowY >= land.length || nowX < 0 || nowX >= land[0].length) continue;
                if (land[nowY][nowX] == 1 && !visited[nowY][nowX]) {
                    count++;
                    visited[nowY][nowX] = true;
                    queue.offer(new int[] {nowY, nowX});
                    set.add(nowX);
                }
            }
        }
     
        for (int nowX : set) oils[nowX] += count;
    }
}