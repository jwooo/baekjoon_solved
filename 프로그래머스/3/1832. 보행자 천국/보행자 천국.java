import java.util.*;

class Solution {
    
    static int[][] left;
    static int[][] up;
    static int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        left = new int[m + 1][n + 1];
        up = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (i == 1 || j == 1) {
                    moveBorder(i, j, cityMap);
                    continue;
                }
                
                if (cityMap[i - 1][j - 1] == 1) continue;
                
                int beforeLeft = cityMap[i - 1][j - 2];
                int beforeUp = cityMap[i - 2][j - 1];
                
                if (beforeLeft == 2) {
                    left[i][j] = left[i][j - 1];
                } else {
                    left[i][j] = (left[i][j - 1] + up[i][j - 1]) % MOD;
                }
                
                if (beforeUp == 2) {
                    up[i][j] = up[i - 1][j];
                } else {
                    up[i][j] = (up[i - 1][j] + left[i - 1][j]) % MOD;
                }
            }
        }
        
        answer = (left[m][n] + up[m][n]) % MOD;
        return answer;
    }
    
    private void moveBorder(int i, int j, int[][] cityMap) {
        if (i == 1 && j == 1) {
            up[i][j] = 1;
            left[i][j] = 1;
        } else if (i == 1 && cityMap[i - 1][j - 1] != 1) {
            left[i][j] = left[i][j - 1];
        } else if (j == 1 && cityMap[i - 1][j - 1] != 1) {
            up[i][j] = up[i - 1][j];
        }
    }
    
}