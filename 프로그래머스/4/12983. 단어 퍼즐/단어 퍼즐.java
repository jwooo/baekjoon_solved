
import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        Set<String> words = new HashSet<>(Arrays.asList(strs));

        int n = t.length();
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= 5 && len <= i; len++) {
                if (dp[i - len] == Integer.MAX_VALUE) {
                    continue;
                }

                String word = t.substring(i - len, i);

                if (words.contains(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}