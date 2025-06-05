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

    static int MOD = 1_000_000_007;

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        long[] dp = new long[5001];
        dp[0] = 1;

        for (int i = 1; i <= 5000; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - 1 - j]) % MOD) % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n % 2 != 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(dp[n / 2]).append("\n");
            }
        }

        System.out.println(sb);
    }

}
