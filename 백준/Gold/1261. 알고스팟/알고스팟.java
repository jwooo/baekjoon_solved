import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] map;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(getMinBrokenCount());
    }

    public int getMinBrokenCount() {
        int[][] count = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        count[0][0] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            int y = now.y;
            int x = now.x;
            int brokenCount = now.brokenCount;

            if (brokenCount > count[y][x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
                    continue;
                }

                int nextBrokenCount = brokenCount + map[nextY][nextX];
                if (count[nextY][nextX] > nextBrokenCount) {
                    count[nextY][nextX] = nextBrokenCount;
                    pq.offer(new Point(nextY, nextX, nextBrokenCount));
                }
            }
        }

        return count[n - 1][m - 1];
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int brokenCount;

        public Point(int y, int x, int brokenCount) {
            this.y = y;
            this.x = x;
            this.brokenCount = brokenCount;
        }

        public int compareTo(Point o) {
            return this.brokenCount - o.brokenCount;
        }
    }

}
