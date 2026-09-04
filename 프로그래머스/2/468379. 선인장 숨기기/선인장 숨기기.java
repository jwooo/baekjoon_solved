import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1;

        int[][] rain = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(rain[i], INF);
        }

        for (int i = 0; i < drops.length; i++) {
            rain[drops[i][0]][drops[i][1]] = i + 1;
        }

        int width = n - w + 1;
        int[][] horizontal = new int[m][width];

        for (int r = 0; r < m; r++) {
            int[] deque = new int[n];
            int head = 0;
            int tail = 0;

            for (int c = 0; c < n; c++) {
                while (head < tail &&
                        rain[r][deque[tail - 1]] >= rain[r][c]) {
                    tail--;
                }

                deque[tail++] = c;

                while (head < tail && deque[head] < c - w + 1) {
                    head++;
                }

                if (c >= w - 1) {
                    horizontal[r][c - w + 1] = rain[r][deque[head]];
                }
            }
        }

        int best = -1;
        int bestRow = 0;
        int bestCol = 0;

        for (int c = 0; c < width; c++) {
            int[] deque = new int[m];
            int head = 0;
            int tail = 0;

            for (int r = 0; r < m; r++) {
                while (head < tail &&
                        horizontal[deque[tail - 1]][c] >= horizontal[r][c]) {
                    tail--;
                }

                deque[tail++] = r;

                while (head < tail && deque[head] < r - h + 1) {
                    head++;
                }

                if (r >= h - 1) {
                    int row = r - h + 1;
                    int value = horizontal[deque[head]][c];

                    if (value > best ||
                            (value == best &&
                                    (row < bestRow ||
                                            (row == bestRow && c < bestCol)))) {
                        best = value;
                        bestRow = row;
                        bestCol = c;
                    }
                }
            }
        }

        return new int[]{bestRow, bestCol};
    }
}