import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static final int INF = 1000000000;

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (!isEnd()) {
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            addAnswer(dijkstra(map), sb);
        }

        System.out.println(sb);
    }

    private int dijkstra(int[][] map) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        pq.offer(new int[]{0, 0, map[0][0]});

        distance[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int y = now[0];
            int x = now[1];
            int d = now[2];

            if (distance[y][x] > d) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
                    continue;
                }

                int nextDistance = d + map[nextY][nextX];
                if (distance[nextY][nextX] > nextDistance) {
                    pq.offer(new int[]{nextY, nextX, nextDistance});
                    distance[nextY][nextX] = nextDistance;
                }
            }
        }

        return distance[n - 1][n - 1];
    }

    private boolean isEnd() throws IOException {
        n = Integer.parseInt(br.readLine());
        return n == 0;
    }

    private void addAnswer(int now, StringBuilder sb) {
        sb.append("Problem ").append(count++).append(": ").append(now).append("\n");
    }
}
