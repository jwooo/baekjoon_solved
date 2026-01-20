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
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] distances = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(distances[i], 100_000_000);
            }

            for (int i = 1; i <= n; i++) {
                distances[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                distances[start][end] = dist;
                distances[end][start] = dist;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }

            int k = Integer.parseInt(br.readLine());
            int[] users = new int[k];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                users[i] = Integer.parseInt(st.nextToken());
            }

            int minDistances = Integer.MAX_VALUE;
            int minNodes = -1;

            for (int i = 1; i <= n; i++) {
                int nowDistance = 0;

                for (int j = 0; j < k; j++) {
                    nowDistance += distances[users[j]][i];
                }

                if (nowDistance < minDistances) {
                    minDistances = nowDistance;
                    minNodes = i;
                }
            }

            sb.append(minNodes).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}
