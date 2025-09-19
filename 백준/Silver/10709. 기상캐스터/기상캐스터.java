import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }

        Queue<int[]> indexes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String now = br.readLine();

            for (int j = 0; j < m; j++) {
                if (now.charAt(j) == 'c') {
                    map[i][j] = 0;
                    indexes.offer(new int[]{i, j});
                }
            }
        }

        while (!indexes.isEmpty()) {
            int[] now = indexes.poll();

            int nextX = now[1] + 1;
            if (nextX >= m) {
                continue;
            }
            if (map[now[0]][nextX] != -1) {
                continue;
            }

            map[now[0]][nextX] = map[now[0]][now[1]] + 1;
            indexes.offer(new int[]{now[0], nextX});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}
