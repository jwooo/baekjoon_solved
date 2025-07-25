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

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int E = 0, S = 0, M = 0;
        int answer = 0;

        while (true) {
            E++;
            S++;
            M++;
            answer++;

            if (E > 15) {
                E = 1;
            }
            if (S > 28) {
                S = 1;
            }
            if (M > 19) {
                M = 1;
            }

            if (e == E && s == S && m == M) {
                break;
            }
        }

        System.out.println(answer);
    }
}
