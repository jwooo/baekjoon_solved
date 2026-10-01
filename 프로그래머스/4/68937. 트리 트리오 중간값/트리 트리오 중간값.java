import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int n;

    public int solution(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int u = bfs(1).node;
        Result resU = bfs(u);
        if (resU.count >= 2) {
            return resU.maxDist;
        }

        Result resV = bfs(resU.node);
        if (resV.count >= 2) {
            return resV.maxDist;
        }

        return resV.maxDist - 1;
    }

    private Result bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int[] q = new int[n + 1];
        int head = 0, tail = 0;

        q[tail++] = start;
        dist[start] = 0;

        while (head < tail) {
            int curr = q[head++];
            for (int next : adj[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q[tail++] = next;
                }
            }
        }

        int maxDist = dist[q[tail - 1]];
        int count = 0;
        for (int i = tail - 1; i >= 0; i--) {
            if (dist[q[i]] == maxDist) {
                count++;
            } else {
                break;
            }
        }

        return new Result(q[tail - 1], maxDist, count);
    }

    private static class Result {
        int node;
        int maxDist;
        int count;

        Result(int node, int maxDist, int count) {
            this.node = node;
            this.maxDist = maxDist;
            this.count = count;
        }
    }
}