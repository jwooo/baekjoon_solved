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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], 100_000_000);
        }

        for (int i = 1; i <= n; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int start = -1;
        int end = -1;
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int d = findDistance(i, j, arr);

                if (d < answer) {
                    start = i;
                    end = j;
                    answer = d;
                }
            }
        }

        System.out.println(start + " " + end + " " + answer);
    }

    private int findDistance(int a, int b, int[][] arr) {
        int answer = 0;

        for (int i = 1; i < arr.length; i++) {
            if (i != a || i != b) {
                answer += Math.min(arr[i][a], arr[i][b]) * 2;
            }
        }

        return answer;
    }

}