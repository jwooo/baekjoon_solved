class Solution {
    static final int MOD = 10000019;

    public int solution(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        long[][] comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        long[] dp = new long[n + 1];
        dp[n] = 1;

        for (int col = 0; col < m; col++) {
            int ones = 0;

            for (int row = 0; row < n; row++) {
                ones += a[row][col];
            }

            long[] next = new long[n + 1];

            for (int even = 0; even <= n; even++) {
                if (dp[even] == 0) {
                    continue;
                }

                int odd = n - even;
                int minX = Math.max(0, ones - odd);
                int maxX = Math.min(even, ones);

                for (int x = minX; x <= maxX; x++) {
                    int y = ones - x;
                    int nextEven = even - x + y;

                    long ways = comb[even][x] * comb[odd][y] % MOD;
                    next[nextEven] = (next[nextEven] + dp[even] * ways % MOD) % MOD;
                }
            }

            dp = next;
        }

        return (int) dp[n];
    }
}