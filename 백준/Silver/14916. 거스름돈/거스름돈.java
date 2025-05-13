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
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n / 5; i++) {
            int now = n - (5 * i);

            if (now % 2 == 0) {
                answer = Math.min(answer, (now / 2) + i);
            }
        }

        answer = answer != Integer.MAX_VALUE ? answer : -1;
        System.out.println(answer);
    }

}
