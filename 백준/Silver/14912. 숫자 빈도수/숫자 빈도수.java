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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int now = i;

            while (now > 0) {
                if (now % 10 == d) {
                    count++;
                }
                now = now / 10;
            }
        }

        System.out.println(count);
    }

}
