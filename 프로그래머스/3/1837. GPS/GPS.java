import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            adj[i].add(i);
        }

        for (int[] edge : edge_list) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        final int INF = 1_000_000;
        int[][] dp = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][gps_log[0]] = 0;

        for (int t = 1; t < k; t++) {
            for (int u = 1; u <= n; u++) {
                if (dp[t - 1][u] == INF) continue;
                for (int v : adj[u]) {
                    int add = (v == gps_log[t]) ? 0 : 1;
                    dp[t][v] = Math.min(dp[t][v], dp[t - 1][u] + add);
                }
            }
        }

        int ans = dp[k - 1][gps_log[k - 1]];
        return ans >= INF ? -1 : ans;
    }
}