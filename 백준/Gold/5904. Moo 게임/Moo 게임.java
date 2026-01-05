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
    static char answer;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        int length = 3;
        int k = 0;
        while (length < n) {
            k++;
            length = 2 * length + (k + 3);
        }

        solve(k, length);
        System.out.println(answer);
    }

    public static void solve(int k, int length) {
        if (k == 0) {
            if (n == 1) {
                answer = 'm';
            } else {
                answer = 'o';
            }
            return;
        }

        int prevLength = (length - (k + 3)) / 2;

        if (n <= prevLength) {
            solve(k - 1, prevLength);
        } else if (n > prevLength + (k + 3)) {
            n -= (prevLength + (k + 3));
            solve(k - 1, prevLength);
        } else {
            n -= prevLength;
            if (n == 1) {
                answer = 'm';
            } else {
                answer = 'o';
            }
        }
    }

}
