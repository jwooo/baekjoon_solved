import java.util.*;

class Solution {
    
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        String[][] map = new String[storage.length][storage[0].length()];
        boolean[][] visited = new boolean[storage.length][storage[0].length()];
        
        for (int i = 0; i < map.length; i++) {
            map[i] = storage[i].split("");
		}
        
       	for (String request : requests) {
            List<int[]> pullContainers;
            
            if (request.length() == 1) pullContainers = useForkLift(request, map, visited);
            else pullContainers = useCrane(String.valueOf(request.charAt(0)), map, visited);
            
            pullContainers.forEach(idx -> visited[idx[0]][idx[1]] = true);
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
                    boolean[][] visitedCopy = Arrays.stream(visited)
                        .map(row -> Arrays.copyOf(row, row.length))
                        .toArray(boolean[][]::new);
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    
                    boolean isOutContainer = false;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        
                        for (int k = 0; k < 4; k++) {
                            int nowY = now[0] + dy[k];
                            int nowX = now[1] + dx[k];
                            
                            if (nowX < 0 || nowX >= map[0].length || nowY < 0 || nowY >= map.length) {
                                isOutContainer = true;
                                pullContainers.add(new int[] {i, j});
                                break;
                            } 
                            
                            if (visitedCopy[nowY][nowX]) {
                                visitedCopy[nowY][nowX] = false;
                                queue.offer(new int[] {nowY, nowX});
                            }
                        }
                        
                        if (isOutContainer) break;
                    }
                }
            }
        }
        
        return pullContainers;
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