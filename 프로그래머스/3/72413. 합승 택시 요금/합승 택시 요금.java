import java.util.*;

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] maps = init(n, fares);
        
        for (int k = 1; k <= n; k++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (maps[start][k] == INF || maps[k][end] == INF) continue;
                    if (maps[start][end] > maps[start][k] + maps[k][end]) {
                        maps[start][end] = maps[start][k] + maps[k][end];
                    }
                }
            }
        }
        
        for (int stopover = 1; stopover <= n; stopover++) {
            int shareCost = maps[s][stopover];
            int costA = maps[stopover][a];
            int costB = maps[stopover][b];
            
            answer = Math.min(answer, shareCost + costA + costB);
        }
        
        return answer;
    }
    
    public int[][] init(int n, int[][] fares) {
        int[][] maps = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(maps[i], INF);
        }
        
        for (int i = 1; i <= n; i++) {
            maps[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            
           	maps[start][end] = weight;
            maps[end][start] = weight;
        }
        
        return maps;
    }
}