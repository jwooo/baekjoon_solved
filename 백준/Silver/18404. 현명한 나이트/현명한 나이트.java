import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startX = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 100_000_000);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX});

        boolean[][] visited = new boolean[n][n];
        visited[startY][startX] = true;
        map[startY][startX] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;
                map[nextY][nextX] = map[now[0]][now[1]] + 1;
                q.offer(new int[]{nextY, nextX});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            sb.append(map[y - 1][x - 1]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}