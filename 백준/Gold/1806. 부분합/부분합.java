import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i];
        }

        int min = Integer.MAX_VALUE;
        int startIndex = 1;
        int endIndex = 1;

        while (startIndex <= n) {
            int sum = dp[endIndex] - dp[startIndex - 1];

            if (sum >= s) {
                min = Math.min(min, endIndex - startIndex + 1);
                startIndex++;
            } else {
                if (endIndex != n) {
                    endIndex++;
                } else {
                    startIndex++;
                }
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}