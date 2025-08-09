import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static List<int[]> viruses = new ArrayList<>();

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 0) {
                    map[i][j] = 0;
                } else if (now == 1) {
                    map[i][j] = -1;
                } else {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        List<Integer> indexes = new ArrayList<>();
        int answer = permutation(0, 0, indexes);
        answer = answer != Integer.MAX_VALUE ? answer : -1;

        System.out.println(answer);
    }

    private int permutation(int depth, int now, List<Integer> indexes) {
        if (depth == m) {
            return bfs(indexes);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = now; i < viruses.size(); i++) {
            indexes.add(i);
            answer = Math.min(answer, permutation(depth + 1, i + 1, indexes));
            indexes.remove(indexes.size() - 1);
        }

        return answer;
    }

    private int bfs(List<Integer> indexes) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] copyMap = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        indexes.forEach(i -> {
            int[] now = viruses.get(i);
            queue.offer(now);
            visited[now[0]][now[1]] = true;
        });

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }
                if (copyMap[nextY][nextX] == -1) {
                    continue;
                }

                visited[nextY][nextX] = true;
                copyMap[nextY][nextX] = copyMap[now[0]][now[1]] + 1;

                queue.offer(new int[]{nextY, nextX});
            }
        }

        int fillUpTime = getFillUpTime(copyMap);
        return fillUpTime;
    }

    private int getFillUpTime(int[][] copyMap) {
        int max = 0;
        int zeroCount = m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroCount < 0) {
                    return Integer.MAX_VALUE;
                }
                if (copyMap[i][j] == 0) {
                    zeroCount--;
                }
                max = Math.max(max, copyMap[i][j]);
            }
        }

        return max;
    }

}
