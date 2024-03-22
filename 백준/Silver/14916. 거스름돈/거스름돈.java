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
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                count = n / 5 + count;
                break;
            }

            n -= 2;
            count++;
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}