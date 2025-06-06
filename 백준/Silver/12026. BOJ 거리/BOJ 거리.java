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
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int num = arr[n - 1] == 'B' ? 0 : arr[n - 1] == 'O' ? 1 : 2;
        dp[n - 1][num] = 0;

        for (int i = n - 1; i > 0; i--) {
            char now = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                char next = arr[j];

                if (now == 'B' && dp[i][0] != Integer.MAX_VALUE) {
                    if (next == 'J') {
                        dp[j][2] = Math.min(dp[j][2], dp[i][0] + (i - j) * (i - j));
                    }
                } else if (now == 'O' && dp[i][1] != Integer.MAX_VALUE) {
                    if (next == 'B') {
                        dp[j][0] = Math.min(dp[j][0], dp[i][1] + (i - j) * (i - j));
                    }
                } else if (now == 'J' && dp[i][2] != Integer.MAX_VALUE) {
                    if (next == 'O') {
                        dp[j][1] = Math.min(dp[j][1], dp[i][2] + (i - j) * (i - j));
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[0][i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, dp[0][i]);
            }
        }

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
    }

}
