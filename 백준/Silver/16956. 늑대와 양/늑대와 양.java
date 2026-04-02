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

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] pasture = new char[r][c];
        for (int i = 0; i < r; i++) {
            pasture[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean possible = true;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pasture[i][j] == 'W') {

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            if (pasture[nx][ny] == 'S') {
                                possible = false;
                                break;
                            }
                        }
                    }
                }
                if (!possible) {
                    break;
                }
            }
            if (!possible) {
                break;
            }
        }

        if (!possible) {
            System.out.println(0);
        } else {
            System.out.println(1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (pasture[i][j] == '.') {
                        sb.append('D');
                    } else {
                        sb.append(pasture[i][j]);
                    }
                }
                sb.append('\n');
            }

            System.out.println(sb);
        }
    }

}