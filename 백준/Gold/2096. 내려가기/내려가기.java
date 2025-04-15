import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp[0][0] = minDp[0][0] = arr[0][0];
        maxDp[0][1] = minDp[0][1] = arr[0][1];
        maxDp[0][2] = minDp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + arr[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    maxDp[i][j] =
                            Math.max(maxDp[i - 1][j], Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j + 1])) + arr[i][j];
                    minDp[i][j] =
                            Math.min(minDp[i - 1][j], Math.min(minDp[i - 1][j - 1], minDp[i - 1][j + 1])) + arr[i][j];
                } else {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1]) + arr[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[n - 1][i]);
            min = Math.min(min, minDp[n - 1][i]);
        }

        System.out.println(max + " " + min);
    }
}
