import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Location> pq = new PriorityQueue<>();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] != 0) {
                    pq.offer(new Location(i, j, 0, arr[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int second = Integer.parseInt(st.nextToken());
        int resultY = Integer.parseInt(st.nextToken());
        int resultX = Integer.parseInt(st.nextToken());

        while (!pq.isEmpty()) {
            Location now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                    continue;
                }
                if (second < now.second + 1) {
                    continue;
                }
                if (arr[nextY][nextX] != 0) {
                    continue;
                }

                arr[nextY][nextX] = now.virus;
                pq.offer(new Location(nextY, nextX, now.second + 1, now.virus));
            }
        }

        System.out.println(arr[resultY - 1][resultX - 1]);
    }

    static class Location implements Comparable<Location> {
        int y;
        int x;
        int second;
        int virus;

        public Location(int y, int x, int second, int virus) {
            this.y = y;
            this.x = x;
            this.second = second;
            this.virus = virus;
        }

        @Override
        public int compareTo(Location o) {
            if (this.second == o.second) {
                return Integer.compare(this.virus, o.virus);
            }

            return Integer.compare(this.second, o.second);
        }
    }

}