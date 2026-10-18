import java.util.*;

class Solution {
    public int[] solution(int m, int n, int s, int[][] time_map) {
        int maxSteps = m * n;
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[m][n];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int step = 1; step < maxSteps; step++) {
            long[][] next = new long[m][n];

            for (long[] row : next) {
                Arrays.fill(row, INF);
            }

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] == INF) {
                        continue;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            continue;
                        }

                        if (time_map[nr][nc] == -1) {
                            continue;
                        }

                        long sum = dp[r][c] + time_map[nr][nc];

                        if (sum <= s && sum < next[nr][nc]) {
                            next[nr][nc] = sum;
                        }
                    }
                }
            }

            if (next[m - 1][n - 1] != INF) {
                return new int[]{step, (int) next[m - 1][n - 1]};
            }

            dp = next;
        }

        return new int[]{-1, -1};
    }
}