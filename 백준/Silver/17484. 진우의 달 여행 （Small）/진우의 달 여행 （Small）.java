import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];
        final int INF = 100 * 1000 + 1; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = grid[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m) {
                    dp[i][j][0] = grid[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                }

                dp[i][j][1] = grid[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);

                if (j - 1 >= 0) {
                    dp[i][j][2] = grid[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }

        int minFuel = INF;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                minFuel = Math.min(minFuel, dp[n-1][j][k]);
            }
        }

        System.out.println(minFuel);
    }
}