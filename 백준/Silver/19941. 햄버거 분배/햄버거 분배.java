import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] bench = br.readLine().toCharArray();
        boolean[] eat = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            char now = bench[i];

            if (now == 'H') {
                continue;
            }

            int hamburger = -1;
            for (int j = i - k; j < i; j++) {
                if (j < 0) {
                    continue;
                }

                if (bench[j] != 'H') {
                    continue;
                }

                if (eat[j]) {
                    continue;
                }

                hamburger = j;
                eat[j] = true;
                answer++;
                break;
            }

            if (hamburger != -1) {
                continue;
            }

            for (int j = i + 1; j < Math.min(i + k + 1, n); j++) {
                if (bench[j] != 'H') {
                    continue;
                }

                if (eat[j]) {
                    continue;
                }

                hamburger = j;
                eat[j] = true;
                answer++;
                break;
            }
        }

        System.out.println(answer);
    }

}