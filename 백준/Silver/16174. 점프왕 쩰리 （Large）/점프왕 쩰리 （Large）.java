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

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nextY = now[0] + dy[i] * map[now[0]][now[1]];
                int nextX = now[1] + dx[i] * map[now[0]][now[1]];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (nextY == n - 1 && nextX == n - 1) {
                    System.out.println("HaruHaru");
                    return;
                }

                visited[nextY][nextX] = true;
                queue.offer(new int[]{nextY, nextX});
            }
        }

        System.out.println("Hing");
    }

}
