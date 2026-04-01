import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Point implements Comparable<Point> {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int essential = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));

        if (essential != 0) {
            int y = (essential - 1) / m;
            int x = (essential - 1) % m;

            points.add(new Point(y + 1, x + 1));
        }

        points.add(new Point(n, m));

        long totalPaths = 1;
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);

            if (start.x > end.x || start.y > end.y) {
                System.out.println(0);
                return;
            }

            totalPaths *= countPaths(start, end);
        }

        System.out.println(totalPaths);
    }

    static int countPaths(Point start, Point end) {
        int dy = end.y - start.y + 1;
        int dx = end.x - start.x + 1;

        int[][] dp = new int[dy + 1][dx + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= dy; i++) {
            for (int j = 1; j <= dx; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dy][dx];
    }

}