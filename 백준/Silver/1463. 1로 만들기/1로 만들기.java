import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        System.out.println(dp[n]);
    }


    public static void input() {
        try {
            n = Integer.parseInt(br.readLine());

            dp = new int[n + 1];

            if (n >= 1 && n <= 3) {
                for (int i = 1; i <= n; i++) {
                    dp[i] = 1;
                }
            } else {
                dp[2] = dp[3] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calculate(int n) {
        if (n <= 1) {
            return 0;
        }

        if (dp[n] != 0) return dp[n];

        dp[n] = calculate(n - 1) + 1;
        if (n % 3 == 0) dp[n] = Math.min(dp[n], calculate(n / 3) + 1);
        if (n % 2== 0) dp[n] = Math.min(dp[n], calculate(n / 2) + 1);

        return dp[n];
    }
}