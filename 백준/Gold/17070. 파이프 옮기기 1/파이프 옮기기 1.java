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

    private static int n;
    private static int result;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Pipe(0, 1, HORIZONTAL), map);
        System.out.println(result);
    }

    private void dfs(Pipe pipe, int[][] map) {
        if (pipe.x == n - 1 && pipe.y == n - 1) {
            result++;
            return;
        }

        boolean isMoveHorizontal = pipe.x + 1 < n && map[pipe.y][pipe.x + 1] != 1;
        boolean isMoveVertical = pipe.y + 1 < n && map[pipe.y + 1][pipe.x] != 1;
        boolean isMoveDiag = isMoveHorizontal && isMoveVertical && map[pipe.y + 1][pipe.x + 1] != 1;

        if (pipe.direction == HORIZONTAL) {
            if (isMoveHorizontal) {
                dfs(new Pipe(pipe.y, pipe.x + 1, HORIZONTAL), map);
            }
            if (isMoveDiag) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, DIAGONAL), map);
            }
        } else if (pipe.direction == VERTICAL) {
            if (isMoveVertical) {
                dfs(new Pipe(pipe.y + 1, pipe.x, VERTICAL), map);
            }
            if (isMoveDiag) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, DIAGONAL), map);
            }
        } else {
            if (isMoveHorizontal) {
                dfs(new Pipe(pipe.y, pipe.x + 1, HORIZONTAL), map);
            }
            if (isMoveVertical) {
                dfs(new Pipe(pipe.y + 1, pipe.x, VERTICAL), map);
            }
            if (isMoveDiag) {
                dfs(new Pipe(pipe.y + 1, pipe.x + 1, DIAGONAL), map);
            }
        }
    }

    static class Pipe {
        int y;
        int x;
        int direction;

        public Pipe(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }
}