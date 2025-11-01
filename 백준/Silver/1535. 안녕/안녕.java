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

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] healthCost = new int[n];
        int[] joys = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            healthCost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            joys[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];
        for (int i = 0; i < n; i++) {
            int cost = healthCost[i];
            int joy = joys[i];

            if (cost < 100) {
                for (int j = 99; j >= cost; j--) {
                    dp[j] = Math.max(dp[j], dp[j - cost] + joy);
                }
            }
        }

        System.out.println(dp[99]);
    }
}