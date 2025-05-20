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

    static int MOD = 1000000009;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1_000_001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i] + dp[i - 1]) % MOD;
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
            dp[i] = (dp[i] + dp[i - 3]) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
            System.out.println(dp[index]);
        }
    }

}
