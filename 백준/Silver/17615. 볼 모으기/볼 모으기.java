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
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int minMoves = Integer.MAX_VALUE;

        int redCount = 0;
        int blueCount = 0;
        for (char ball : balls.toCharArray()) {
            if (ball == 'R') {
                redCount++;
            } else {
                blueCount++;
            }
        }

        int leftRedContiguous = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') {
                leftRedContiguous++;
            } else {
                break;
            }
        }

        minMoves = Math.min(minMoves, redCount - leftRedContiguous);

        int rightRedContiguous = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') {
                rightRedContiguous++;
            } else {
                break;
            }
        }

        minMoves = Math.min(minMoves, redCount - rightRedContiguous);

        int leftBlueContiguous = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'B') {
                leftBlueContiguous++;
            } else {
                break;
            }
        }

        minMoves = Math.min(minMoves, blueCount - leftBlueContiguous);

        int rightBlueContiguous = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') {
                rightBlueContiguous++;
            } else {
                break;
            }
        }

        minMoves = Math.min(minMoves, blueCount - rightBlueContiguous);
        System.out.println(minMoves);
    }
}