import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        TreeSet<Integer> xSet = new TreeSet<>();
        TreeSet<Integer> ySet = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            xSet.add(data[i][0]);
            ySet.add(data[i][1]);
        }
        
        Map<Integer, Integer> xMap = new HashMap<>();
        int xIdx = 0;
        for (int x : xSet) {
            xMap.put(x, xIdx++);
        }
        
        Map<Integer, Integer> yMap = new HashMap<>();
        int yIdx = 0;
        for (int y : ySet) {
            yMap.put(y, yIdx++);
        }
        
        int[][] compressedData = new int[n][2];
        for (int i = 0; i < n; i++) {
            compressedData[i][0] = xMap.get(data[i][0]);
            compressedData[i][1] = yMap.get(data[i][1]);
        }
        
        int maxX = xSet.size();
        int maxY = ySet.size();
        int[][] sum = new int[maxX + 1][maxY + 1];
        
        for (int i = 0; i < n; i++) {
            sum[compressedData[i][0] + 1][compressedData[i][1] + 1] += 1;
        }
        
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int x1 = data[i][0];
            int y1 = data[i][1];
            
            for (int j = i + 1; j < n; j++) {
                int x2 = data[j][0];
                int y2 = data[j][1];
                
                if (x1 == x2 || y1 == y2) continue;
                
                int minY = Math.min(y1, y2);
                int maxY_val = Math.max(y1, y2);
                
                int cx1 = xMap.get(x1);
                int cx2 = xMap.get(x2);
                int cy1 = yMap.get(minY);
                int cy2 = yMap.get(maxY_val);
                
                int innerCount = query(sum, cx1 + 1, cy1 + 1, cx2 - 1, cy2 - 1);
                
                if (innerCount == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private int query(int[][] sum, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return 0;
        return sum[x2 + 1][y2 + 1] - sum[x1][y2 + 1] - sum[x2 + 1][y1] + sum[x1][y1];
    }
}