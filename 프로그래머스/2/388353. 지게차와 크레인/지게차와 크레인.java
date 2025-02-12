import java.util.*;

class Solution {
    
    private static int n = 0;
    private static int m = 0;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        n = storage.length;
        m = storage[0].length();
        
        String[][] map = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < map.length; i++) {
            map[i] = storage[i].split("");
		}
        
       	for (String request : requests) {
            List<int[]> pullContainers;
            
            if (request.length() == 1) pullContainers = useForkLift(request, map, visited);
            else pullContainers = useCrane(String.valueOf(request.charAt(0)), map, visited);
            
            pullContainers.forEach(idx -> {
                map[idx[0]][idx[1]] = ".";
                visited[idx[0]][idx[1]] = true;
            });
        }
        
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) answer++;
            }
        }
        
        return answer;
    }
    
    private List<int[]> useForkLift(String container, String[][] map, boolean[][] visited) {
        List<int[]> pullContainers = new ArrayList<>();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals(container) && !visited[i][j]) {
                    if (isContainerAccessible(i, j, map)) pullContainers.add(new int[] {i, j});
                }
            }
        }
        
        return pullContainers;
    }
    
    private boolean isContainerAccessible(int startY, int startX, String[][] map) {
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startY, startX});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];

                if (nowX < 0 || nowX >= map[0].length || nowY < 0 || nowY >= map.length) return true;
                if (map[nowY][nowX].equals(".") && !visited[nowY][nowX]) {
                    visited[nowY][nowX] = true;
                    queue.offer(new int[] {nowY, nowX});
                }
            }
        }

        return false;
    }
    
    private List<int[]> useCrane(String container, String[][] map, boolean[][] visited) {
        List<int[]> pullContainers = new ArrayList<>();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals(container) && !visited[i][j]) pullContainers.add(new int[]{i, j});
            }
        }
        
        return pullContainers;
    }
    
}