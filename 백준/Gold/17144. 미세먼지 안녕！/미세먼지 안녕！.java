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

    static int C;
    static int R;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int upper = 0;
        int lower = 0;

        R = n;
        C = m;

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (upper == 0) {
                        upper = i;
                    } else {
                        lower = i;
                    }
                }
            }
        }

        for (int test = 0; test < t; test++) {
            List<Dust> dusts = getDust(map);

            for (Dust dust : dusts) {
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nowY = dust.y + dy[i];
                    int nowX = dust.x + dx[i];

                    if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m || map[nowY][nowX] == -1) {
                        continue;
                    }
                    map[nowY][nowX] += dust.value / 5;
                    count++;
                }

                map[dust.y][dust.x] = map[dust.y][dust.x] - dust.value + (dust.value - (dust.value / 5 * count));
            }

            purify(upper, lower, map);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    public void purify(int upper, int lower, int[][] map) {
        for (int r = upper - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < upper; r++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[upper][c] = map[upper][c - 1];
        }
        map[upper][1] = 0;

        for (int r = lower + 1; r < R - 1; r++) {
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }
        for (int r = R - 1; r > lower; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[lower][c] = map[lower][c - 1];
        }
        map[lower][1] = 0;
    }


    private List<Dust> getDust(int[][] map) {
        List<Dust> dusts = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    dusts.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        return dusts;
    }

    static class Dust {
        int y;
        int x;
        int value;

        public Dust(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}