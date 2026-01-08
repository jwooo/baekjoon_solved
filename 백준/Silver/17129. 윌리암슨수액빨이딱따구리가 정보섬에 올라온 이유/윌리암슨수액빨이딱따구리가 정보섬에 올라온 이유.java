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

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] start = new int[2];
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';

                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int y = now[0];
            int x = now[1];
            int dist = now[2];

            if (map[now[0]][now[1]] > 2) {
                System.out.println("TAK");
                System.out.println(dist);

                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + now[0];
                int nextX = dx[i] + now[1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX] == 1) {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX, dist + 1});
            }
        }

        System.out.println("NIE");
    }

}
