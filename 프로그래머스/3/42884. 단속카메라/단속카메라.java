import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (i, j) -> Integer.compare(i[1], j[1]));
        int lastCameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
             int entryPoint = route[0];
            int exitPoint = route[1];
            
            if (entryPoint > lastCameraPosition) {
                answer++;
                lastCameraPosition = exitPoint;
            }
        }
        
        return answer;
    }
}