import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static long[][] dp = new long[31][31];

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            sb.append(solve(n, 0)).append("\n");
        }

        System.out.println(sb);
    }

    private long solve(int whole, int half) {
        if (whole == 0) {
            return 1;
        }

        if (dp[whole][half] != 0) {
            return dp[whole][half];
        }

        long count = 0;

        count += solve(whole - 1, half + 1);
        if (half > 0) {
            count += solve(whole, half - 1);
        }

        return dp[whole][half] = count;
    }

}