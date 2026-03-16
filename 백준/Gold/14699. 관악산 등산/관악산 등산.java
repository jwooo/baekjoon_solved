import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int[] heights;
    static List<List<Integer>> adj;
    static int[] dp;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        heights = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (heights[u] < heights[v]) {
                adj.get(u).add(v);
            } else if (heights[v] < heights[u]) {
                adj.get(v).add(u);
            }
        }

        dp = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dfs(i)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static int dfs(int now) {
        if (dp[now] != 0) {
            return dp[now];
        }

        int maxVisitsFromNext = 0;

        for (int next : adj.get(now)) {
            maxVisitsFromNext = Math.max(maxVisitsFromNext, dfs(next));
        }

        return dp[now] = maxVisitsFromNext + 1;
    }

}