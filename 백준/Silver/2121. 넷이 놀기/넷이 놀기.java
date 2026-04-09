import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Set<Point> points = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            points.add(new Point(px, py));
        }

        int answer = 0;
        for (Point now : points) {
            if (findSquare(x, y, now, points)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private boolean findSquare(int x, int y, Point now, Set<Point> points) {
        if (!points.contains(new Point(now.x + x, now.y))) {
            return false;
        }
        if (!points.contains(new Point(now.x + x, now.y + y))) {
            return false;
        }
        if (!points.contains(new Point(now.x, now.y + y))) {
            return false;
        }

        return true;
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