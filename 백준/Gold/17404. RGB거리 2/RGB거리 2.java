import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[n][3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], 1_000_000_000);
            }
        }

        dp[0][0][0] = costs[0][0];
        dp[0][1][1] = costs[0][1];
        dp[0][2][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0][j] = Math.min(dp[i - 1][1][j], dp[i - 1][2][j]) + costs[i][0];
                dp[i][1][j] = Math.min(dp[i - 1][0][j], dp[i - 1][2][j]) + costs[i][1];
                dp[i][2][j] = Math.min(dp[i - 1][0][j], dp[i - 1][1][j]) + costs[i][2];
            }
        }

        int minCost = Integer.MAX_VALUE;

        minCost = Math.min(minCost, dp[n - 1][1][0]);
        minCost = Math.min(minCost, dp[n - 1][2][0]);

        minCost = Math.min(minCost, dp[n - 1][0][1]);
        minCost = Math.min(minCost, dp[n - 1][2][1]);

        minCost = Math.min(minCost, dp[n - 1][0][2]);
        minCost = Math.min(minCost, dp[n - 1][1][2]);

        System.out.println(minCost);
    }

}
