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
    static char[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                if (dfs(i, j, i, j, map[i][j], 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    private boolean dfs(int y, int x, int fromY, int fromX, char color, int count) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (map[ny][nx] != color) {
                continue;
            }
            if (ny == fromY && nx == fromX) {
                continue;
            }
            if (visited[ny][nx] && count >= 4) {
                return true;
            }
            if (dfs(ny, nx, y, x, color, count + 1)) {
                return true;
            }
        }

        return false;
    }
}
