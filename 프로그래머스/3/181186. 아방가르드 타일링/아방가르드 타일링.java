class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int n) {
        long[] dp = new long[Math.max(n + 1, 7)];
        long[] sum = new long[Math.max(n + 1, 7)];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        sum[0] = 1;
        sum[1] = 1;
        sum[2] = 3;

        for (int i = 3; i <= n; i++) {
            long val = dp[i - 1];
            val += 2 * dp[i - 2];
            val += 5 * dp[i - 3];

            if (i >= 4) {
                val += 2 * sum[i - 4];
            }
            if (i >= 5) {
                val += 2 * sum[i - 5];
            }
            if (i >= 6) {
                val += 4 * sum[i - 6];
            }

            dp[i] = val % MOD;
            sum[i] = (dp[i] + (i >= 3 ? sum[i - 3] : 0)) % MOD;
        }

        return (int) dp[n];
    }
}
