import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = {0, 0};

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char now = line.charAt(j);
                map[i][j] = now;
                if (now == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];

                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                    continue;
                }
                if (map[nowY][nowX] != 'X' && !visited[nowY][nowX]) {
                    if (map[nowY][nowX] == 'P') {
                        answer++;
                    }
                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY, nowX});
                }
            }
        }

        if (answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println("TT");
        }
    }

}