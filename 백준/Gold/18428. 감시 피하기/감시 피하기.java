import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static List<int[]> teachers = new ArrayList<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                char now = st.nextToken().charAt(0);
                if (now == 'T') {
                    teachers.add(new int[]{i, j});
                }
                map[i][j] = now;
            }
        }

        if (combination(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private boolean combination(int depth, int now) {
        if (depth == 3) {
            for (int[] teacher : teachers) {
                for (int i = 0; i < 4; i++) {
                    if (!findStudents(teacher[0], teacher[1], i)) {
                        return false;
                    }
                }
            }

            return true;
        }

        for (int i = now; i < n * n; i++) {
            int y = i / n;
            int x = i % n;

            if (map[y][x] != 'X') {
                continue;
            }

            map[y][x] = 'O';
            if (combination(depth + 1, i + 1)) {
                return true;
            }
            map[y][x] = 'X';
        }

        return false;
    }

    private boolean findStudents(int y, int x, int distance) {
        int nextY = y + dy[distance];
        int nextX = x + dx[distance];

        if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
            return true;
        }
        if (map[nextY][nextX] == 'O') {
            return true;
        }
        if (map[nextY][nextX] == 'S') {
            return false;
        }

        return findStudents(nextY, nextX, distance);
    }

}
