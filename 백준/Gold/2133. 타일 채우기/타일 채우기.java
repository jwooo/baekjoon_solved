import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[31];

        dp[2] = 3;

        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * dp[2];

            for (int j = i-4; j >= 2; j-=2) {
                dp[i] += dp[j] * 2;
            }

            dp[i] += 2;
        }

        System.out.println(dp[n]);

    }
}
