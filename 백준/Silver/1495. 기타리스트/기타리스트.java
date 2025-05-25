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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][s] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    if (arr[i] + j <= m) {
                        dp[i][arr[i] + j] = true;
                    }
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}
