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

    static int n;
    static int m;
    static int distance;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};


    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = lines.charAt(j);
            }
        }

        dfs(n - 1, 0, 0);
        System.out.println(answer);
    }

    private void dfs(int y, int x, int d) {
        if (d == distance - 1) {
            if (y == 0 && x == m - 1) {
                answer++;
            }

            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                continue;
            }
            if (visited[nextY][nextX]) {
                continue;
            }
            if (map[nextY][nextX] == 'T') {
                continue;
            }

            dfs(nextY, nextX, d + 1);
        }

        visited[y][x] = false;
    }

}
