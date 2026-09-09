import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int targetAlp = 0;
        int targetCop = 0;

        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        if (alp >= targetAlp && cop >= targetCop) {
            return 0;
        }

        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        int[][] dp = new int[targetAlp + 1][targetCop + 1];

        for (int i = 0; i <= targetAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int a = alp; a <= targetAlp; a++) {
            for (int c = cop; c <= targetCop; c++) {

                if (dp[a][c] == Integer.MAX_VALUE) {
                    continue;
                }

                if (a < targetAlp) {
                    dp[a + 1][c] = Math.min(
                        dp[a + 1][c],
                        dp[a][c] + 1
                    );
                }

                if (c < targetCop) {
                    dp[a][c + 1] = Math.min(
                        dp[a][c + 1],
                        dp[a][c] + 1
                    );
                }

                for (int[] problem : problems) {

                    int reqAlp = problem[0];
                    int reqCop = problem[1];
                    int rewardAlp = problem[2];
                    int rewardCop = problem[3];
                    int cost = problem[4];

                    if (a < reqAlp || c < reqCop) {
                        continue;
                    }

                    int nextAlp = Math.min(
                        targetAlp,
                        a + rewardAlp
                    );

                    int nextCop = Math.min(
                        targetCop,
                        c + rewardCop
                    );

                    dp[nextAlp][nextCop] = Math.min(
                        dp[nextAlp][nextCop],
                        dp[a][c] + cost
                    );
                }
            }
        }

        return dp[targetAlp][targetCop];
    }
}