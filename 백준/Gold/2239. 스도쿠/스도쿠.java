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

    static int[][] board = new int[9][9];

    public void solution() throws IOException {
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();

            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        solve(0, 0);
    }

    public static void solve(int y, int x) {
        if (x == 9) {
            solve(y + 1, 0);
            return;
        }

        if (y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString().trim());
            System.exit(0);
        }

        if (board[y][x] != 0) {
            solve(y, x + 1);
            return;
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(y, x, num)) {
                board[y][x] = num;
                solve(y, x + 1);
            }
        }

        board[y][x] = 0;
    }

    private static boolean isValid(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][x] == num) {
                return false;
            }
        }

        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

}