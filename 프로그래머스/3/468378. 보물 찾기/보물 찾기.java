import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        long[][] dp = new long[n][n];

        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                long best = Long.MAX_VALUE;

                for (int k = l; k <= r; k++) {
                    long left = k > l ? dp[l][k - 1] : 0;
                    long right = k < r ? dp[k + 1][r] : 0;
                    long cost = depth[k] + Math.max(left, right);
                    best = Math.min(best, cost);
                }

                dp[l][r] = best;
            }
        }

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            for (int k = l; k <= r; k++) {
                long left = k > l ? dp[l][k - 1] : 0;
                long right = k < r ? dp[k + 1][r] : 0;
                long cost = depth[k] + Math.max(left, right);

                if (cost == dp[l][r]) {
                    int result = excavate.apply(k + 1);

                    if (result == 0) {
                        return k + 1;
                    } else if (result < 0) {
                        r = k - 1;
                    } else {
                        l = k + 1;
                    }
                    break;
                }
            }
        }

        return 0;
    }
}