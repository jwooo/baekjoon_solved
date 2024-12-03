import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public int[] solution(String[] maps) {
        // given
        List<Integer> result = new ArrayList<>();
        
        int mapYSize = maps.length;
        int mapXSize = maps[0].length();
        
        int[][] map = new int[mapYSize][mapXSize];
        boolean[][] visited = new boolean[mapYSize][mapXSize];
        
        for (int i = 0; i < mapYSize; i++) {
            for (int j = 0; j < mapXSize; j++) {
                char now = maps[i].charAt(j);
                
                if (now == 'X') map[i][j] = 0;
                else map[i][j] = now - '0';
            }
        }
        
        // when 
        for (int i = 0; i < mapYSize; i++) {
            for (int j = 0; j < mapXSize; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    int sum = map[i][j];
                   
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        
                        for (int k = 0; k < 4; k++) {
                            int nowY = now[0] + dy[k];
                            int nowX = now[1] + dx[k];
                            
                            if (nowY >= 0 && nowY < mapYSize && nowX >= 0 && nowX < mapXSize) {
                                if (map[nowY][nowX] != 0 && !visited[nowY][nowX]) {
                                    sum += map[nowY][nowX];
                                    queue.add(new int[]{nowY, nowX});
                                    visited[nowY][nowX] = true;
                                }
                            }
                        }
                    }
                    
                    result.add(sum);
                }
            }
        }
        
        Collections.sort(result);
        
        // then
        return result.isEmpty() 
            ? new int[]{-1} 
        	: result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}