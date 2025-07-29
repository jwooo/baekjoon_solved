import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int answer = 0;
    static int[] dy = {1, 1, 0, -1, -1, 0};
    static int[] dx = {0, -1, -1, 0, 1, 1};
    static char[][] map;
    static int[][] color;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        color = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                color[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X' && color[i][j] == -1) {
                    bfs(i, j);
                    if (answer == 3) {
                        System.out.println(3);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});

        color[startY][startX] = 0;
        answer = Math.max(answer, 1);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
                    continue;
                }
                if (map[nextY][nextX] != 'X') {
                    continue;
                }

                if (color[nextY][nextX] == -1) {
                    color[nextY][nextX] = 1 - color[now[0]][now[1]];
                    answer = Math.max(answer, 2);
                    queue.offer(new int[]{nextY, nextX});
                } else if (color[nextY][nextX] == color[now[0]][now[1]]) {
                    answer = 3;
                    return;
                }
            }
        }
    }
}
