import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
        }

        int[] distance = dijkstra(startNode, graph);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i != startNode && distance[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distance[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public int[] dijkstra(int start, List<List<Edge>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (distance[now.node] < now.weight) {
                continue;
            }
            for (Edge next : graph.get(now.node)) {
                int dist = now.weight + next.weight;

                if (distance[next.node] > dist) {
                    distance[next.node] = dist;
                    queue.offer(new Edge(next.node, dist));
                }
            }
        }

        return distance;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }
}