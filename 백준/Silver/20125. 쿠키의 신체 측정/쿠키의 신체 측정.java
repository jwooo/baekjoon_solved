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

    static int n;
    static char[][] map;
    // 상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = now.charAt(j);
            }
        }

        int[] heart = findHeartIndex();

        int left = countLength(heart[0], heart[1], 3, 0);
        int right = countLength(heart[0], heart[1], 1, 0);
        int waist = countLength(heart[0], heart[1], 2, 0);

        int leftLeg = countLength(heart[0] + waist, heart[1] - 1, 2, 0);
        int rightLeg = countLength(heart[0] + waist, heart[1] + 1, 2, 0);

        StringBuilder sb = new StringBuilder();

        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        sb.append(left).append(" ").append(right).append(" ").append(waist).append(" ").append(leftLeg).append(" ")
                .append(rightLeg);

        System.out.println(sb);
    }

    private int[] findHeartIndex() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*' && validAllDirections(i, j)) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private boolean validAllDirections(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY < 0 || nextX < 0 || nextY >= n && nextY >= n) {
                continue;
            }
            if (map[nextY][nextX] == '_') {
                return false;
            }
        }

        return true;
    }

    private int countLength(int y, int x, int direction, int count) {
        int nextY = y + dy[direction];
        int nextX = x + dx[direction];

        if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
            return count;
        }
        if (map[nextY][nextX] != '*') {
            return count;
        }

        return countLength(nextY, nextX, direction, count + 1);
    }
}
