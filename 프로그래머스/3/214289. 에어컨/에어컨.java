import java.util.*;

class Solution {
    private static final int INF = 1_000_000_000;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[] dp = new int[51];
        Arrays.fill(dp, INF);
        dp[temperature + 10] = 0;

        for (int i = 1; i < onboard.length; i++) {
            int[] next = new int[51];
            Arrays.fill(next, INF);

            for (int temp = -10; temp <= 40; temp++) {
                int cost = dp[temp + 10];

                if (cost == INF) {
                    continue;
                }

                update(next, temp, cost + b, t1, t2, onboard[i]);
                update(next, temp - 1, cost + a, t1, t2, onboard[i]);
                update(next, temp + 1, cost + a, t1, t2, onboard[i]);

                int outsideNext = temp + Integer.compare(temperature, temp);
                update(next, outsideNext, cost, t1, t2, onboard[i]);
            }

            dp = next;
        }

        int answer = INF;

        for (int cost : dp) {
            answer = Math.min(answer, cost);
        }

        return answer;
    }

    private void update(int[] dp, int temp, int cost, int t1, int t2, int onboard) {
        if (temp < -10 || temp > 40) {
            return;
        }

        if (onboard == 1 && (temp < t1 || temp > t2)) {
            return;
        }

        dp[temp + 10] = Math.min(dp[temp + 10], cost);
    }
}