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

    static int[] weight;
    static int[] value;
    static int[][] dp;

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        weight = new int[n];
        value = new int[n];
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int answer = knapsack(0, k);
        System.out.println(answer);
    }

    private int knapsack(int index, int nowWeight) {
        if (index == dp.length) {
            return 0;
        }

        if (dp[index][nowWeight] != -1) {
            return dp[index][nowWeight];
        }

        int best = knapsack(index + 1, nowWeight);
        if (nowWeight >= weight[index]) {
            best = Math.max(best, value[index] + knapsack(index + 1, nowWeight - weight[index]));
        }

        dp[index][nowWeight] = best;
        return dp[index][nowWeight];
    }
}