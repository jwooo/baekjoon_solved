import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long result = 0;
    static long[][] dp;
    static int mod = 1_000_000_000;

    public static void main(String[] args) {
        input();
        calculate();
        output();
    }

    public static void input() {
        try {
            n = Integer.parseInt(br.readLine());
            dp = new long[n+1][10];

            dp[1][0] = 0;

            for (int i = 1; i < 10; i++) {
                dp[1][i] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate() {
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j+1];
                else if (j == 9) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
    }

    public static void output() {
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % mod;
        }

        System.out.println(result);
    }
}