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

    public void solution() throws IOException {
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[n][10];

            Arrays.fill(dp[0], 1);
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < 10; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dp[n - 1][i];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}
