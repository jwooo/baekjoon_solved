import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static char[][] map;
    static int[][] dist;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;

        Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{startY, startX});
        dist[startY][startX] = 0;

        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            int y = now[0];
            int x = now[1];

            if (map[y][x] == '#') {
                System.out.println(dist[y][x] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (dist[nextY][nextX] != -1) { 
                    continue;
                }

                if (map[nextY][nextX] == '0' || map[nextY][nextX] == '#') {
                    dist[nextY][nextX] = dist[y][x];
                    deque.offerFirst(new int[]{nextY, nextX}); 
                } else if (map[nextY][nextX] == '1') {
                    dist[nextY][nextX] = dist[y][x] + 1;
                    deque.offerLast(new int[]{nextY, nextX}); 
                }
            }
        }
    }
}