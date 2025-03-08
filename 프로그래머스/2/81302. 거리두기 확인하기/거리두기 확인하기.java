import java.util.*;

class Solution {
    
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < places.length; i++) {
            String[] nowPlace = places[i];
            String[][] map = parsePlace(nowPlace);
            
            answer.add(findResult(map));
        }
     
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
   private int findResult(String[][] map) {
       for (int i = 0; i < map.length; i++) {
           for (int j = 0; j < map[i].length; j++) {
               if (map[i][j].equals("P") && checkDistance(i, j, map) == 0) return 0;
           }
       }
       
       return 1;
   }
    
   private String[][] parsePlace(String[] nowPlace) {
       String[][] map = new String[nowPlace.length][nowPlace[0].length()];
       
       for (int i = 0; i < map.length; i++) {
           for (int j = 0; j < map[i].length; j++) {
               map[i][j] = String.valueOf(nowPlace[i].charAt(j));
           }
       }
       
       return map;
   }
    
    private int checkDistance(int y, int x, String[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x, 0});
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                int count = now[2];
                
                if (nowY < 0 || nowY >= 5 || nowX < 0 || nowX >= 5) continue;
                if (!map[nowY][nowX].equals("X") && !visited[nowY][nowX]) {
                    if (map[nowY][nowX].equals("O")) {
                        visited[nowY][nowX] = true;
                        queue.offer(new int[] {nowY, nowX, count + 1});
                    } else {
                        if (count + 1 <= 2) return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
}