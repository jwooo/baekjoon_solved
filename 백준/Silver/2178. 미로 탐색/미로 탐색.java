import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = now.charAt(j) == '1' ? 1 : 0;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX] == 0) {
                    continue;
                }
                if (nextY == n - 1 && nextX == m - 1) {
                    System.out.println(now[2] + 1);
                    return;
                }

                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX, now[2] + 1});
            }
        }
    }
}
