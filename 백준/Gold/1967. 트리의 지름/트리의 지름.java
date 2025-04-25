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

    static int answer = 0;

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<List<Edge>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Edge(end, weight));
            tree.get(end).add(new Edge(start, weight));
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            dfs(i, 0, tree, visited);
        }

        System.out.println(answer);
    }

    private void dfs(int now, int sum, List<List<Edge>> tree, boolean[] visited) {
        visited[now] = true;
        answer = Math.max(answer, sum);

        for (Edge edge : tree.get(now)) {
            if (!visited[edge.node]) {
                visited[edge.node] = true;
                dfs(edge.node, sum + edge.weight, tree, visited);
            }
        }
    }

    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}