import java.util.*;

class Solution {
    
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean isDone = false;
        boolean[][] poped = new boolean[m][n];
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        
        while (!isDone) {
            boolean isPoped = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char now = map[i][j];
                    
                    if (now != ' ') {
                        int sameCount = 0;
                        for (int k = 0; k < 3; k++) {
                            char block = map[i + dx[k]][j + dy[k]];
                            
                            if (now == block) sameCount++;
                        }
                        
                        if (sameCount == 3) {
                            isPoped = true;
                            poped[i][j] = true;
                            poped[i][j + 1] = true;
                            poped[i + 1][j] = true;
                            poped[i + 1][j + 1] = true;
                        }
                    }
                }
            }
            
            
            if (isPoped) {
                for (int i = m - 1; i >= 0; i--) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (poped[i][j]) {
                            for (int k = i - 1; k >= 0; k--) {
                                if (map[k][j] != ' ' && !poped[k][j]) {
                                    poped[i][j] = false;
                                    poped[k][j] = true;
                                    map[i][j] = map[k][j];
                                    map[k][j] = ' ';
                                    break;
                                }
                            }
                            
                            if (poped[i][j]) {
                                map[i][j] = ' ';
                                poped[i][j] = false;
                            }
                        }
                    }
                }
                
            } else {
                isDone = true;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == ' ') answer++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        return answer;
    }
}