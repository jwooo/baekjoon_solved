import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = n;
        }

        for (int i = 2; i <=n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - (j * j)] + 1) {
                    dp[i] = dp[i - (j * j)] + 1;
                }
            }
        }

        System.out.println(dp[n]);
    }
}