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

        int[] dp = new int[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = j + arr[j][0];

                if (prev <= i) {
                    if (arr[i][0] + i <= n) {
                        dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
                    } else {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
            }

            if (arr[i][0] + i <= n) {
                dp[i] = Math.max(dp[i], arr[i][1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
