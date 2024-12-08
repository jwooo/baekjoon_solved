import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    
    public int solution(String[] board) {
        // given
        int answer = -1;
        
        int boardYSize = board.length;
        int boardXSize = board[0].length();
        
        visited = new boolean[boardYSize][boardXSize];
        map = new char[boardYSize][boardXSize];
        
        for (int i = 0; i < boardYSize; i++) {
            for (int j = 0; j < boardXSize; j++) {
                map[i][j] = board[i].charAt(j);
                
                if (map[i][j] == 'R') {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        // when
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowY = now.getY() + dy[i];
                int nowX = now.getX() + dx[i];
                
                while (isInternalMap(nowY, nowX)) {
                    if (map[nowY][nowX] == 'D') break;
                    nowY += dy[i];
                    nowX += dx[i];
                }
                
                nowY -= dy[i];
                nowX -= dx[i];
                
                if (isInternalMap(nowY, nowX)) {
                    if (!visited[nowY][nowX]) {
                        queue.offer(new Node(nowY, nowX, now.getCount() + 1));
                        visited[nowY][nowX] = true;
                        
                        if (map[nowY][nowX] == 'G') answer = now.getCount() + 1;
                    }
                }
            }
        }
        
        // then
        return answer;
    }
    
    private boolean isInternalMap(int nowY, int nowX) {
        int y = map.length;
        int x = map[0].length;
        
        return nowY < y && nowY >= 0 && nowX < x && nowX >= 0;
    }
    
    static class Node { 
        
        private int y;
        private int x;
        private int count;
        
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
}