import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int max = 0;
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n+1];
            int[][] dp = new int[3][n+1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[0][1];
            dp[2][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[2][j-1]);
                dp[1][j] = Math.max(dp[2][j-1], dp[0][j-1]) + arr[0][j];
                dp[2][j] = Math.max(dp[1][j-1], dp[0][j-1]) + arr[1][j];
            }

            max(dp[0][n], dp[1][n], dp[2][n]);

        }

    }

    static void max(int a, int b, int c) {
        int max = a;

        if (max < b) max = b;
        if (max < c) max = c;

        System.out.println(max);
    }

}