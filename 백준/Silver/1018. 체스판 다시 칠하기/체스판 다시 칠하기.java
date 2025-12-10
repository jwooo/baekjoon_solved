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

    static char[][] board;
    static int minRepaintCount = Integer.MAX_VALUE;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = lines.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                findMinRepaints(i, j);
            }
        }

        System.out.println(minRepaintCount);
    }

    public void findMinRepaints(int startRow, int startCol) {
        int repaintCountW = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColor;

                if ((i + j) % 2 == 0) {
                    expectedColor = 'W';
                } else {
                    expectedColor = 'B';
                }

                if (board[startRow + i][startCol + j] != expectedColor) {
                    repaintCountW++;
                }
            }
        }

        int repaintCountB = 64 - repaintCountW;
        int nowMin = Math.min(repaintCountW, repaintCountB);

        minRepaintCount = Math.min(minRepaintCount, nowMin);
    }
}