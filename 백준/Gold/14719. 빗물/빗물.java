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

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rainCount = 0;

        boolean[][] map = new boolean[n][m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int wallHeight = Integer.parseInt(st.nextToken());

            for (int j = n - 1; wallHeight > 0; j--) {
                map[j][i] = true;
                wallHeight--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) {
                    boolean hasLeftWall = false;
                    boolean hasRightWall = false;

                    for (int k = j - 1; k >= 0; k--) {
                        if (map[i][k]) {
                            hasLeftWall = true;
                            break;
                        }
                    }

                    for (int k = j + 1; k < m; k++) {
                        if (map[i][k]) {
                            hasRightWall = true;
                            break;
                        }
                    }

                    if (hasLeftWall && hasRightWall) {
                        rainCount++;
                    }
                }
            }
        }

        System.out.println(rainCount);
    }
}