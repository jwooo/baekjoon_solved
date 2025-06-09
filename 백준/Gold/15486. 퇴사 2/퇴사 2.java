import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] schedules = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        for (int i = n; i > 0; i--) {
            int endSchedules = i + schedules[i][0];
            int nowCost = schedules[i][1];

            if (endSchedules <= n + 1) {
                dp[i] = Math.max(dp[i + 1], dp[endSchedules] + nowCost);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }

}
