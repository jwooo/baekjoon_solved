class Solution {
    static final int MOD = 1000000007;

    public int solution(int[][] grid, int[] d, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;

        int[][] base = new int[size][size];

        for (int i = 0; i < size; i++) {
            base[i][i] = 1;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int slope : d) {
            int[][] next = new int[size][size];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    int from = r * m + c;

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                            continue;
                        }

                        if (grid[nr][nc] - grid[r][c] == slope) {
                            int to = nr * m + nc;
                            next[from][to] = 1;
                        }
                    }
                }
            }

            base = multiply(base, next);
        }

        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        long exponent = k;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            exponent >>= 1;
        }

        long answer = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                answer = (answer + result[i][j]) % MOD;
            }
        }

        return (int) answer;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) {
                    continue;
                }

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) {
                        continue;
                    }

                    result[i][j] = (int) (
                        (result[i][j] + (long) a[i][k] * b[k][j]) % MOD
                    );
                }
            }
        }

        return result;
    }
}