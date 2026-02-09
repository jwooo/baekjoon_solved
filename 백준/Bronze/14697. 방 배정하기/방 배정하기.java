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

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(st.nextToken());
        dfs(0, n, arr);
        System.out.println(0);
    }

    static void dfs(int depth, int now, int[] arr) {
        if (depth == 3) {

            if (now == 0) {
                System.out.println(1);
                System.exit(0);
            }

            return;
        }

        for (int i = 1; i <= now / arr[depth]; i++) {
            dfs(depth + 1, now - arr[depth] * i, arr);
        }
    }

}