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

    static final int MOD = 1000000009;

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        int[][] dp = new int[100_001][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            long sum = 0;

            sum += dp[n][1];
            sum += dp[n][2];
            sum += dp[n][3];

            answerBuilder.append((int) (sum % MOD)).append("\n");
        }

        System.out.println(answerBuilder);
    }

}
