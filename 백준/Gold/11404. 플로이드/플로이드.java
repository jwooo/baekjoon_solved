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
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            int now = map[start][end];

            if (map[start][end] == 0) {
                map[start][end] = weight;
            } else {
                map[start][end] = Math.min(now, weight);
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (start == end) {
                        continue;
                    }
                    if (map[start][k] == Integer.MAX_VALUE || map[k][end] == Integer.MAX_VALUE) {
                        continue;
                    }

                    map[start][end] = Math.min(map[start][end], map[start][k] + map[k][end]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != Integer.MAX_VALUE) {
                    sb.append(map[i][j]);
                } else {
                    sb.append(0);
                }

                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
