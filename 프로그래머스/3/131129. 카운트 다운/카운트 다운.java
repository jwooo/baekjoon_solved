import java.util.*;

class Solution {

    static class Shot {
        int score;
        int single;

        Shot(int score, int single) {
            this.score = score;
            this.single = single;
        }
    }

    public int[] solution(int target) {

        List<Shot> shots = new ArrayList<>();

        for (int i = 1; i <= 20; i++)
            shots.add(new Shot(i, 1));

        for (int i = 1; i <= 20; i++)
            shots.add(new Shot(i * 2, 0));

        for (int i = 1; i <= 20; i++)
            shots.add(new Shot(i * 3, 0));

        shots.add(new Shot(50, 1));

        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i <= target; i++) {

            for (Shot s : shots) {

                if (i < s.score)
                    continue;

                int prev = i - s.score;

                int dart = dp[prev][0] + 1;
                int single = dp[prev][1] + s.single;

                if (dart < dp[i][0]) {
                    dp[i][0] = dart;
                    dp[i][1] = single;
                } else if (dart == dp[i][0] && single > dp[i][1]) {
                    dp[i][1] = single;
                }
            }
        }

        return dp[target];
    }
}