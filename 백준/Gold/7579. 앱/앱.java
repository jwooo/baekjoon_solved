import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int m = Integer.parseInt(st.nextToken());

        int[] memories = new int[n];
        int[] costs = new int[n];
        int totalCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            totalCost += costs[i];
        }

        int[] dp = new int[totalCost + 1];
        for (int i = 0; i < n; i++) {
            int memory = memories[i];
            int cost = costs[i];

            for (int j = totalCost; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + memory);
            }
        }

        int minCost = 0;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= m) {
                minCost = i;
                break;
            }
        }

        System.out.println(minCost);
    }

}