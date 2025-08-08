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

    static int n;
    static int m;
    static int answer = 0;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] map;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    private int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x, 0});

        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX] == 1) {
                    return now[2] + 1;
                }

                queue.offer(new int[]{nextY, nextX, now[2] + 1});
                visited[nextY][nextX] = true;
            }
        }

        return -1;
    }


}
