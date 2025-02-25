import java.util.*;

class Solution {
    
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        
        map = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        if (!existPath(start, lever, 'L', maps)) return -1;
        if (!existPath(lever, end, 'E', maps)) return -1;
        
        answer = map[end[0]][end[1]];
        return answer;
    }
    
    private boolean existPath(int[] start, int[] end, char event, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});
        
       	boolean[][] visited = new boolean[map.length][map[0].length];
       	visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                
                if (nowY >= 0 && nowY < map.length && nowX >= 0 && nowX < map[0].length) {
                    if (maps[nowY].charAt(nowX) != 'X' && !visited[nowY][nowX]) {
                        map[nowY][nowX] = map[now[0]][now[1]] + 1;
                        visited[nowY][nowX] = true;
                        
                        if (maps[nowY].charAt(nowX) == event) return true;
                        else queue.offer(new int[] {nowY, nowX});
                    }
                }
            }
        }
        
        return false;
    }
}