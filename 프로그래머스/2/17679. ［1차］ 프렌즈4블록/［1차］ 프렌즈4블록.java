import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean isDone = false;
        char[][] map = new char[m][n];
        boolean[][] poped = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (!isDone) {
            boolean isPoped = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char now = map[i][j];

                    if (now == '*') continue;
                    else {
                        if (now == map[i][j + 1] && now == map[i + 1][j] && now == map[i + 1][j + 1]) {
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
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (poped[i][j]) {
                            map[i][j] = '*';
                            poped[i][j] = false;
                            answer++;
                        }
                    }
                }
                
                for (int i = m - 1; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == '*') {
                            for (int k = i - 1; k >= 0; k--) {
                                if (map[k][j] != '*') {
                                    map[i][j] = map[k][j];
                                    map[k][j] = '*';
                                    break;
                                }
                            }
                        }
                    }
                }
            } else isDone = true;
        }

        return answer;
    }
}