import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static List<Point> points;

    public void solution() throws IOException {
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            points = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points.add(new Point(x, y));
            }

            if (isReachable()) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean isReachable() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            Point now = points.get(idx);

            if (idx == n + 1) {
                return true;
            }

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i]) {
                    Point next = points.get(i);
                    int distance = now.getManhattanDistance(next);

                    if (distance <= 1000) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }

        return false;
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getManhattanDistance(Point o) {
            return Math.abs(this.x - o.x) + Math.abs(this.y - o.y);
        }
    }

}