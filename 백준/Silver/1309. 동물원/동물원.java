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

    static int MOD = 9901;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);
    }

}
