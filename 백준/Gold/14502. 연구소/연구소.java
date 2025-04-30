import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int answer = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Set<int[]> viruses = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0, map, viruses);
        System.out.println(answer);
    }

    public void combination(int depth, int now, int[][] map, Set<int[]> viruses) {
        if (depth == 3) {
            answer = Math.max(answer, bfs(map, viruses));
            return;
        }

        for (int i = now; i < map.length * map[0].length; i++) {
            int y = i / map[0].length;
            int x = i % map[0].length;

            if (map[y][x] == 0) {
                map[y][x] = 1;
                combination(depth + 1, now + 1, map, viruses);
                map[y][x] = 0;
            }
        }
    }

    public int bfs(int[][] map, Set<int[]> viruses) {
        int size = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int[] virus : viruses) {
            queue.offer(new int[]{virus[0], virus[1]});
            visited[virus[0]][virus[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];

                if (nowX < 0 || nowX >= map[0].length || nowY < 0 || nowY >= map.length) {
                    continue;
                }
                if (!visited[nowY][nowX] && map[nowY][nowX] == 0) {
                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY, nowX});
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    size++;
                }
            }
        }

        return size;
    }
}