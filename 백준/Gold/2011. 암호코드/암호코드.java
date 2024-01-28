import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String password = br.readLine();
        int mod = 1_000_000;
        int[] dp = new int[password.length()+1];

        dp[0] = 1;

        for(int i = 1; i <= password.length(); i++) {
            int now = password.charAt(i-1) - '0';

            if(now >= 1 && now <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= mod;
            }
            if(i == 1) continue;

            int prev = password.charAt(i-2) - '0';
            if(prev == 0) continue;

            int value = prev*10+now;

            if(value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= mod;
            }
        }

        System.out.println(dp[password.length()]);
    }
}