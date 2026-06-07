import java.util.*;

class Solution {
    
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int nowY = 0;
        int nowX = 0;
        
        char[][] map = new char[park.length][park[0].length()];
        
        for (int i = 0; i < park.length; i++) {
            String line = park[i];
            
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
                
                if (line.charAt(j) == 'S') {
                    nowY = i;
                    nowX = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);
            
            int d = findDirection(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            int ny = nowY;
            int nx = nowX;
            boolean canMove = true;
            
            for (int j = 0; j < count; j++) {
                int nextY = ny + dy[d];
                int nextX = nx + dx[d];
                
                if (nextY < 0 || 
                   nextY >= map.length || 
                   nextX < 0 || 
                   nextX >= map[0].length ||
                   map[nextY][nextX] == 'X') {
                    canMove = false;
                    break;
                } else {
                    ny = nextY;
                    nx = nextX;
                }
            }
            
            if (canMove) {
                nowY = ny;
                nowX = nx;
            }
        }
        
        answer = new int[] {nowY, nowX};
        return answer;
    }
    
    private int findDirection(String direction) {
        if (direction.equals("E")) {
            return 0;
        } else if (direction.equals("W")) {
            return 1;
        } else if (direction.equals("S")) {
            return 2;
        } else {
            return 3;
        }
    }
}