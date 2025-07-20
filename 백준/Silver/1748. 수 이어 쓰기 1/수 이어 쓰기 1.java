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

        int answer = 0;
        int count = 1;
        int length = 10;

        for (int i = 1; i <= n; i++) {
            if (i == length) {
                count++;
                length *= 10;
            }

            answer += count;
        }

        System.out.println(answer);
    }

}
