import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
         
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                
                if (nowY >= 0 && nowY < maps.length && nowX >= 0 && nowX < maps[0].length) {
                    if (maps[nowY][nowX] != 0 && !visited[nowY][nowX]) {
                        queue.offer(new int[]{nowY, nowX});
                        visited[nowY][nowX] = true;
                        maps[nowY][nowX] = maps[now[0]][now[1]] + 1;
                    }
                }
            }
        }
        
        answer = maps[maps.length -1][maps[0].length - 1];
        return answer != 1 ? answer : -1;
    }
    
}