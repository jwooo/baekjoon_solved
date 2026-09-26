import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;

        while (true) {
            boolean removed = false;

            for (int num = 1; num <= 200; num++) {
                int minR = n, maxR = -1;
                int minC = n, maxC = -1;
                int count = 0;

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (board[r][c] == num) {
                            minR = Math.min(minR, r);
                            maxR = Math.max(maxR, r);
                            minC = Math.min(minC, c);
                            maxC = Math.max(maxC, c);
                            count++;
                        }
                    }
                }

                if (count == 0) {
                    continue;
                }

                int height = maxR - minR + 1;
                int width = maxC - minC + 1;

                if (height * width != 6) {
                    continue;
                }

                int empty = 0;
                boolean possible = true;

                for (int r = minR; r <= maxR; r++) {
                    for (int c = minC; c <= maxC; c++) {
                        if (board[r][c] == 0) {
                            empty++;

                            for (int k = 0; k < r; k++) {
                                if (board[k][c] != 0) {
                                    possible = false;
                                    break;
                                }
                            }

                            if (!possible) {
                                break;
                            }
                        } else if (board[r][c] != num) {
                            possible = false;
                            break;
                        }
                    }

                    if (!possible) {
                        break;
                    }
                }

                if (possible && empty == 2) {
                    for (int r = minR; r <= maxR; r++) {
                        for (int c = minC; c <= maxC; c++) {
                            if (board[r][c] == num) {
                                board[r][c] = 0;
                            }
                        }
                    }

                    answer++;
                    removed = true;
                }
            }

            if (!removed) {
                break;
            }
        }

        return answer;
    }
}