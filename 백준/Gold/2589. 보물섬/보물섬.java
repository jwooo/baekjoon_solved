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

    static int answer = Integer.MIN_VALUE;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = lines.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int y, int x) {
        int n = map.length;
        int m = map[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x, 0});

        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int count = now[2];

            answer = Math.max(answer, count);

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + now[0];
                int nextX = dx[i] + now[1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX] == 'W') {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX, count + 1});
            }
        }
    }

}
