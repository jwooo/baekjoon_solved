import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int betterThan = Integer.parseInt(st.nextToken());
        int lowerThan = Integer.parseInt(st.nextToken());
        List<int[]> list;

        boolean isOpen = true;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMove = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;

                    if (!visited[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        list = new ArrayList<>();

                        queue.add(new int[]{i, j});
                        list.add(new int[]{i, j});
                        visited[i][j] = true;
                        sum = map[i][j];

                        while (!queue.isEmpty()) {
                            int[] now = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nextY = now[0] + dy[k];
                                int nextX = now[1] + dx[k];

                                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                                    if (!visited[nextY][nextX]) {
                                        int value = Math.abs(map[now[0]][now[1]] - map[nextY][nextX]);

                                        if (value >= betterThan && value <= lowerThan) {
                                            visited[nextY][nextX] = true;
                                            queue.add(new int[]{nextY, nextX});
                                            list.add(new int[]{nextY, nextX});
                                            sum += map[nextY][nextX];
                                        }
                                    }
                                }
                            }
                        }

                        if (list.size() > 1) {
                            int average = sum / list.size();

                            for (int[] nowValue : list) {
                                map[nowValue[0]][nowValue[1]] = average;
                            }
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) break;
            result++;
        }

        System.out.println(result);
    }
}
