import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Set<Point> footholds = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            footholds.add(new Point(x, y));
        }

        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{new Point(0, 0), 0});

        Set<Point> visited = new HashSet<>();
        visited.add(new Point(0, 0));

        int minMoves = -1;

        while (!q.isEmpty()) {
            Object[] now = q.poll();

            Point nowPoint = (Point) now[0];
            int moves = (int) now[1];

            if (nowPoint.y == t) {
                minMoves = moves;
                break;
            }

            for (int dy = -2; dy <= 2; dy++) {
                for (int dx = -2; dx <= 2; dx++) {
                    int nextX = nowPoint.x + dx;
                    int nextY = nowPoint.y + dy;

                    Point nextPoint = new Point(nextX, nextY);

                    if (footholds.contains(nextPoint) && !visited.contains(nextPoint)) {
                        visited.add(nextPoint);
                        q.add(new Object[]{nextPoint, moves + 1});
                    }
                }
            }
        }

        System.out.println(minMoves);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}