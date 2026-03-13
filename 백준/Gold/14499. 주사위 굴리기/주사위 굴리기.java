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

    static int[] dice = new int[6];
    static int n, m, x, y;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());

            int nx = x + dx[command - 1];
            int ny = y + dy[command - 1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            roll(command);

            x = nx;
            y = ny;

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[0]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void roll(int command) {
        int temp;
        int top = dice[0], bottom = dice[1], front = dice[2], back = dice[3], left = dice[4], right = dice[5];

        switch (command) {
            case 1:
                temp = top;
                dice[0] = left;
                dice[4] = bottom;
                dice[1] = right;
                dice[5] = temp;
                break;
            case 2:
                temp = top;
                dice[0] = right;
                dice[5] = bottom;
                dice[1] = left;
                dice[4] = temp;
                break;
            case 3:
                temp = top;
                dice[0] = front;
                dice[2] = bottom;
                dice[1] = back;
                dice[3] = temp;
                break;
            case 4:
                temp = top;
                dice[0] = back;
                dice[3] = bottom;
                dice[1] = front;
                dice[2] = temp;
                break;
        }
    }

}