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

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    map[i][j] = now;
                } else {
                    map[i][j] = now + map[i][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            int sizeY = endY - (startY - 1);
            int sizeX = endX - (startX - 1);
            int size = sizeY * sizeX;

            int value = 0;
            for (int j = startY; j <= endY; j++) {
                if (startX == 0) {
                    value += map[j][endX];
                } else {
                    value += map[j][endX] - map[j][startX - 1];
                }
            }

            sb.append(value / size).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}
