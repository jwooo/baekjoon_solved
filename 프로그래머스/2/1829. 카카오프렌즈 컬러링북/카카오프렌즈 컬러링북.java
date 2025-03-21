import java.util.*;

class Solution {
    
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, getSizeOfArea(i, j, picture, visited));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int getSizeOfArea(int y, int x, int[][] picture, boolean[][] visited) {
        int size = 1;
        int sizeOfY = picture.length;
        int sizeOfX = picture[0].length;
        int findNumber = picture[y][x];
        
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                
                if (nowX < 0 || nowX >= sizeOfX || nowY < 0 || nowY >= sizeOfY) continue;
                if (picture[nowY][nowX] == findNumber && !visited[nowY][nowX]) {
                    size++;
                    visited[nowY][nowX] = true;
                    queue.offer(new int[] {nowY, nowX});
                }
            }
        }
        
        return size;
    }
}