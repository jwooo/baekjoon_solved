import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();
        calculate();
        output();
    }


    public static void input() {
        try {
            n = Integer.parseInt(br.readLine());

            dp = new int[n + 1];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate() {
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }
    }

    public static void output() {
        System.out.println(dp[n]);
    }
}
