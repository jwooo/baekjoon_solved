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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[][] dp = new long[n][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][arr[1]] = 1;
        int resultNumber = Integer.parseInt(st.nextToken());

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i - 1][j] >= 0) {
                    int next = j + arr[i];
                    int prev = j - arr[i];

                    if (next <= 20) {
                        dp[i][next] += dp[i - 1][j];
                    }
                    if (prev >= 0) {
                        dp[i][prev] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][resultNumber]);
    }

}
