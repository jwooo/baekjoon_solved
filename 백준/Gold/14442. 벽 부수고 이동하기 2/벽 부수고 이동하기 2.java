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

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String lines = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = lines.charAt(j) - '0';
            }
        }

        int[][][] distances = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(distances[i][j], Integer.MAX_VALUE);
            }
        }

        distances[0][0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int y = now[0];
            int x = now[1];
            int brokenCount = now[2];
            int nowDistance = distances[y][x][brokenCount];

            if (y == n - 1 && x == m - 1) {
                System.out.println(distances[y][x][brokenCount]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (map[nextY][nextX] == 0) {
                    if (distances[nextY][nextX][brokenCount] > nowDistance + 1) {
                        distances[nextY][nextX][brokenCount] = nowDistance + 1;
                        queue.offer(new int[]{nextY, nextX, brokenCount});
                    }
                } else {
                    if (brokenCount < k) {
                        int nextBrokenCount = brokenCount + 1;
                        if (distances[nextY][nextX][nextBrokenCount] > nowDistance + 1) {
                            distances[nextY][nextX][nextBrokenCount] = nowDistance + 1;
                            queue.offer(new int[]{nextY, nextX, nextBrokenCount});
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
