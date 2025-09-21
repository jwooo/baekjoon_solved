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

    static int meltingTime = 0;
    static int nowCheeseCount = 0;
    static int prevCheeseCount = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while ((nowCheeseCount = countCheese(map)) > 0) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextY = now[0] + dy[i];
                    int nextX = now[1] + dx[i];

                    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                        continue;
                    }
                    if (visited[nextY][nextX]) {
                        continue;
                    }
                    if (map[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        map[nextY][nextX] = 0;
                    } else {
                        visited[nextY][nextX] = true;
                        map[nextY][nextX] = 0;
                        queue.offer(new int[]{nextY, nextX});
                    }
                }
            }

            meltingTime++;
            prevCheeseCount = nowCheeseCount;
        }

        System.out.println(meltingTime);
        System.out.println(prevCheeseCount);
    }

    private int countCheese(int[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
