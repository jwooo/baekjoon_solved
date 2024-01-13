import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        input();
        calculate();
    }


    public static void input() {
        try {
            n = Integer.parseInt(br.readLine());

            dp = new long[1001];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate() {
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}