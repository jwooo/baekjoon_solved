import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int[] amount = new int[n+1];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = amount[1];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + amount[i];
            if (i > 2) dp[i][1] = Math.max(dp[i][1], dp[i-3][2] + amount[i]);
            dp[i][2] = dp[i-1][1] + amount[i];
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result ,Math.max(dp[i][1], dp[i][2]));
        }

        System.out.println(result);
    }
}