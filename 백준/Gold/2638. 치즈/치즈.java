import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int answer = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            List<int[]> cheese = findCheese(map);

            if (cheese.isEmpty()) {
                break;
            }

            boolean[][] outside = getOutside(map);
            List<int[]> filteredCheese = cheese.stream()
                    .filter(i -> isAiringPlace(i, outside))
                    .collect(Collectors.toList());

            filteredCheese.forEach(i -> map[i[0]][i[1]] = 0);
            answer++;
        }

        System.out.println(answer);
    }

    public List<int[]> findCheese(int[][] map) {
        List<int[]> cheese = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cheese.add(new int[]{i, j});
                }
            }
        }

        return cheese;
    }

    public boolean[][] getOutside(int[][] map) {
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];

                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                    continue;
                }
                if (map[nowY][nowX] == 0 && !visited[nowY][nowX]) {
                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY, nowX});
                }
            }
        }

        return visited;
    }

    public boolean isAiringPlace(int[] cheese, boolean[][] outside) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nowY = cheese[0] + dy[i];
            int nowX = cheese[1] + dx[i];

            if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                continue;
            }
            if (outside[nowY][nowX]) {
                count++;
            }
        }

        return count >= 2;
    }

}