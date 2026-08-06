import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<List<int[]>> paths = new ArrayList<>();

        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            
            int r = points[route[0] - 1][0];
            int c = points[route[0] - 1][1];
            
            path.add(new int[] {r, c});

            for (int i = 1; i < route.length; i++) {
                int targetR = points[route[i] - 1][0];
                int targetC = points[route[i] - 1][1];

                while (r != targetR) {
                    if (r < targetR) r++;
                    else r--;
                    path.add(new int[]{r, c});
                }
                
                while (c != targetC) {
                    if (c < targetC) c++;
                    else c--;
                    path.add(new int[]{r, c});
                }
            }
            
            paths.add(path);
        }

        int maxTime = 0;
        for (List<int[]> path : paths) {
            maxTime = Math.max(maxTime, path.size());
        }

        for (int t = 0; t < maxTime; t++) {
            Map<Integer, Integer> positionCount = new HashMap<>();
            
            for (List<int[]> path : paths) {
                if (t < path.size()) {
                    int[] pos = path.get(t);
                    int key = pos[0] * 1000 + pos[1];
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }

            for (int count : positionCount.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
}