import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dt = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dt[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = dt[0];
        
        if (n > 1) {
            dp[1] = dp[0] + dt[1];
            if (n > 2) {
                dp[2] = Math.max(dt[0] + dt[2], dt[1] + dt[2]);
            }
        }


        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-3] + dt[i-1] + dt[i], dp[i-2] + dt[i]);
        }

        System.out.println(dp[n-1]);

    }
}