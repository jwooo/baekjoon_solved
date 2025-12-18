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

        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (children[j] < children[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLisLength = 0;
        for (int l : dp) {
            if (l > maxLisLength) {
                maxLisLength = l;
            }
        }

        System.out.println(n - maxLisLength);
    }
}
