import java.util.*;

class Solution {
    List<Edge>[] graph;
    int K;
    int answer = 0;
    int[] order;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        K = k;
        order = new int[k];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];

            graph[u].add(new Edge(v, t));
            graph[v].add(new Edge(u, t));
        }

        dfs(0, infection);
        return answer;
    }
    
    void dfs(int depth, int infected) {

        if (depth == K) {
            answer = Math.max(answer, simulate(infected));
            return;
        }

        for (int type = 1; type <= 3; type++) {
            order[depth] = type;
            dfs(depth + 1, infected);
        }
    }

    int simulate(int start) {

        boolean[] infected = new boolean[graph.length];
        infected[start] = true;

        int cnt = 1;

        for (int pipe : order) {

            Queue<Integer> q = new ArrayDeque<>();

            for (int i = 1; i < infected.length; i++)
                if (infected[i])
                    q.offer(i);

            while (!q.isEmpty()) {

                int now = q.poll();

                for (Edge next : graph[now]) {

                    if (next.type != pipe)
                        continue;

                    if (infected[next.to])
                        continue;

                    infected[next.to] = true;
                    cnt++;
                    q.offer(next.to);
                }
            }
        }

        return cnt;
    }
    
    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

}