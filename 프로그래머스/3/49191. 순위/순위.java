import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        
        int ansewr = 0;
        for (int i = 1; i <= n; i++) {
            int knowRelationsCount = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                
                if (graph[i][j] != 0) {
                    knowRelationsCount++;
                }
                
                if (knowRelationsCount == n - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}