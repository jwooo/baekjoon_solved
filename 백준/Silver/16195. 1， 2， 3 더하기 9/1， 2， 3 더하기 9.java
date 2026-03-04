import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int MAX_N = 1000;
    static final int MAX_M = 1000;
    static final long MOD = 1_000_000_009;

    static long[][] dp = new long[MAX_M + 1][MAX_N + 1];

    static {
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;

        for (int i = 2; i <= MAX_M; i++) {
            for (int j = 1; j <= MAX_N; j++) {
                if (j - 1 >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                if (j - 2 >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 2]) % MOD;
                }
                if (j - 3 >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 3]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long answer = 0;
            for (int i = 1; i <= m; i++) {
                answer = (answer + dp[i][n]) % MOD;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}