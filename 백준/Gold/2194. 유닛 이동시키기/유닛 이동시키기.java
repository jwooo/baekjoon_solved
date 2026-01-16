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

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = -1;
        }

        st = new StringTokenizer(br.readLine());
        int[] start = getTokenByInteger();

        st = new StringTokenizer(br.readLine());
        int[] end = getTokenByInteger();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int nowY = now[0];
            int nowX = now[1];

            if (nowY == end[0] && nowX == end[1]) {
                System.out.println(map[nowY][nowX]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (isUnableMove(nextY, nextX, a, b, map)) {
                    continue;
                }

                queue.offer(new int[]{nextY, nextX});
                visited[nextY][nextX] = true;
                map[nextY][nextX] = map[nowY][nowX] + 1;
            }
        }

        System.out.println(-1);
    }

    private boolean isUnableMove(int y, int x, int a, int b, int[][] map) {
        if (y + a - 1 >= map.length || x + b - 1 >= map[0].length) {
            return true;
        }

        for (int i = y; i < y + a; i++) {
            for (int j = x; j < x + b; j++) {
                if (map[i][j] == -1) {
                    return true;
                }
            }
        }

        return false;
    }

    private int[] getTokenByInteger() {
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        return new int[]{y, x};
    }

}
