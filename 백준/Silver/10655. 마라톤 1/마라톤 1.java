import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Point[] checkPoints = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            checkPoints[i] = new Point(x, y);
        }

        long totalDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            totalDistance += manhattanDistance(checkPoints[i], checkPoints[i + 1]);
        }

        int maxSaving = 0;
        for (int i = 1; i < n - 1; i++) {
            Point prev = checkPoints[i - 1];
            Point now = checkPoints[i];
            Point next = checkPoints[i + 1];

            int distanceRemoved = manhattanDistance(prev, now) + manhattanDistance(now, next);
            int distanceAdded = manhattanDistance(prev, next);

            int nowSaving = distanceRemoved - distanceAdded;

            if (nowSaving > maxSaving) {
                maxSaving = nowSaving;
            }
        }

        long finalDistance = totalDistance - maxSaving;
        System.out.println(finalDistance);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
