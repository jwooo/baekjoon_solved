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
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = n; j >= 1; j--) {
                for (int m = 1; m <= c; m++) {
                    int prevAmount = j - m * p;

                    if (prevAmount >= 0) {
                        dp[j] += dp[prevAmount];
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(dp[n]);
    }

}
