import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows][columns];
        
        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = ++n;
            }
        }
        
        for (int[] query : queries) {
            int startY = query[0] - 1;
            int startX = query[1] - 1;
            int endY = query[2] - 1;
            int endX = query[3] - 1;
            
            int min = map[startY][startX];
            int prev = min;
         
            for (int i = startX + 1; i <= endX; i++) {
                int temp = map[startY][i];
                map[startY][i] = prev;
                prev = temp;
                
                min = Math.min(prev, min);
            }
            
            for (int i = startY + 1; i <= endY; i++) {
                int temp = map[i][endX];
                map[i][endX] = prev;
                prev = temp;
                
                min = Math.min(prev, min);
            }
            
            for (int i = endX - 1; i >= startX; i--) {
                int temp = map[endY][i];
                map[endY][i] = prev;
                prev = temp;
                
                min = Math.min(prev, min);
            }
            
            for (int i = endY - 1; i >= startY; i--) {
                int temp = map[i][startX];
                map[i][startX] = prev;
                prev = temp;
                
                min = Math.min(prev, min);
            }
            
            answer.add(min);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}