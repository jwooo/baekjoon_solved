import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            int k = Integer.parseInt(br.readLine());

            int[] files = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[k + 1];
            for (int i = 0; i < k; i++) {
                sum[i + 1] = sum[i] + files[i];
            }

            int[][] dp = new int[k][k];
            for (int len = 2; len <= k; len++) {
                for (int i = 0; i <= k - len; i++) {
                    int j = i + len - 1;

                    dp[i][j] = Integer.MAX_VALUE;

                    for (int l = i; l < j; l++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j] + (sum[j + 1] - sum[i]));
                    }
                }
            }

            sb.append(dp[0][k - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }

}
