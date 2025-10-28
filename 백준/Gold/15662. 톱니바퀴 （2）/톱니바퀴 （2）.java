import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static char[][] gears;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        gears = new char[n][8];
        for (int i = 0; i < n; i++) {
            gears[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] rotations = new int[n];
            rotations[gearNum] = direction;

            for (int j = gearNum - 1; j >= 0; j--) {
                if (gears[j][2] != gears[j + 1][6]) {
                    rotations[j] = -rotations[j + 1];
                } else {
                    break;
                }
            }

            for (int j = gearNum + 1; j < n; j++) {
                if (gears[j][6] != gears[j - 1][2]) {
                    rotations[j] = -rotations[j - 1];
                } else {
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (rotations[j] != 0) {
                    rotate(j, rotations[j]);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (gears[i][0] == '1') {
                count++;
            }
        }

        System.out.println(count);
    }

    private void rotate(int gearNum, int direction) {
        if (direction == 1) {
            char temp = gears[gearNum][7];
            for (int i = 7; i > 0; i--) {
                gears[gearNum][i] = gears[gearNum][i - 1];
            }
            gears[gearNum][0] = temp;
        } else {
            char temp = gears[gearNum][0];
            for (int i = 0; i < 7; i++) {
                gears[gearNum][i] = gears[gearNum][i + 1];
            }
            gears[gearNum][7] = temp;
        }
    }
}