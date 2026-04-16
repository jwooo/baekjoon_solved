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
    static int strength;
    static int healStrength;
    static int answer = 0;
    static Point startPoint;
    static List<Point> points = new ArrayList<>();
    static boolean[] visited;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        strength = Integer.parseInt(st.nextToken());
        healStrength = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 0) {
                    continue;
                } else if (now == 1) {
                    startPoint = new Point(i, j);
                } else {
                    points.add(new Point(i, j));
                }
            }
        }

        Collections.sort(points);
        visited = new boolean[points.size()];
        dfs(startPoint.y, startPoint.x, strength, 0);

        System.out.println(answer);
    }

    static void dfs(int nowY, int nowX, int nowStrength, int count) {
        int distByStart = getDistanceByStart(new Point(nowY, nowX));

        if (nowStrength >= distByStart) {
            answer = Math.max(answer, count);
        }

        Point now = new Point(nowY, nowX);
        for (int i = 0; i < points.size(); i++) {
            Point next = points.get(i);
            int dist = getDistance(now, next);

            if (!visited[i] && nowStrength >= dist) {
                visited[i] = true;
                dfs(next.y, next.x, nowStrength - dist + healStrength, count + 1);
                visited[i] = false;
            }
        }
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(getDistanceByStart(this), getDistanceByStart(o));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static int getDistanceByStart(Point now) {
        return getDistance(startPoint, now);
    }

    static int getDistance(Point o1, Point o2) {
        return Math.abs(o1.y - o2.y) + Math.abs(o1.x - o2.x);
    }
}