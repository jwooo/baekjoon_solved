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
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};


    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private void dfs(int depth, int now) {
        if (depth == 3) {
            answer = Math.min(answer, now);
            return;
        }

        for (int i = 0; i < n * n; i++) {
            int y = i / n;
            int x = i % n;

            if (!isRightPath(y, x)) {
                continue;
            }

            redoVisited(y, x);
            int cost = getCost(y, x);

            dfs(depth + 1, now + cost);

            undoVisited(y, x);
        }
    }

    private int getCost(int y, int x) {
        int cost = map[y][x];

        for (int i = 0; i < 4; i++) {
            cost += map[y + dy[i]][x + dx[i]];
        }

        return cost;
    }

    private void redoVisited(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            visited[y + dy[i]][x + dx[i]] = true;
        }
    }

    private void undoVisited(int y, int x) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            visited[y + dy[i]][x + dx[i]] = false;
        }
    }

    private boolean isRightPath(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                return false;
            }
            if (visited[nextY][nextX]) {
                return false;
            }
        }

        return true;
    }

}
