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

    static int n, l;
    static int[][] map;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPassable(map[i])) {
                count++;
            }
        }

        for (int j = 0; j < n; j++) {
            int[] colPath = new int[n];
            for (int i = 0; i < n; i++) {
                colPath[i] = map[i][j];
            }

            if (isPassable(colPath)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPassable(int[] path) {
        boolean[] ramp = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = path[i] - path[i + 1];

            if (Math.abs(diff) > 1) {
                return false;
            }

            if (diff == 0) {
                continue;
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    int prevIndex = i - j;
                    if (prevIndex < 0 || path[i] != path[prevIndex] || ramp[prevIndex]) {
                        return false;
                    }
                }

                for (int j = 0; j < l; j++) {
                    ramp[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 0; j < l; j++) {
                    int nextIndex = i + 1 + j;
                    if (nextIndex >= n || path[i + 1] != path[nextIndex] || ramp[nextIndex]) {
                        return false;
                    }
                }

                for (int j = 0; j < l; j++) {
                    ramp[i + 1 + j] = true;
                }
            }
        }
        return true;
    }
}