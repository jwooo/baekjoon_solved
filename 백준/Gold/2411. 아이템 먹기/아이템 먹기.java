import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int itemCount;
    static int obstructionCount;
    static int[][] grid;

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
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        itemCount = Integer.parseInt(st.nextToken());
        obstructionCount = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];
        List<Point> items = new ArrayList<>();
        items.add(new Point(1, 1));

        for (int i = 0; i < itemCount; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            items.add(new Point(y, x));
            grid[y][x] = 1;
        }

        items.add(new Point(n, m));
        Collections.sort(items);
        for (int i = 0; i < obstructionCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            grid[y][x] = -1;
        }

        long totalPaths = 1;
        for (int i = 0; i < items.size() - 1; i++) {
            Point start = items.get(i);
            Point end = items.get(i + 1);

            if (end.x < start.x) {
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

                int realY = i + start.y - 1;
                int realX = j + start.x - 1;

                if (grid[realY][realX] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[dy][dx];
    }

}