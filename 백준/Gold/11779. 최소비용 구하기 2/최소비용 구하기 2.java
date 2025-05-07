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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        dijkstra(start, target, graph);
    }

    public void dijkstra(int start, int target, List<List<Edge>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        Edge startEdge = new Edge(start, 0);
        startEdge.prevEdges.add(start);
        queue.offer(startEdge);

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (distance[now.node] < now.weight) {
                continue;
            }
            if (target == now.node) {
                System.out.println(now.weight);
                System.out.println(now.prevEdges.size());

                StringBuilder sb = new StringBuilder();
                now.prevEdges.forEach(i -> sb.append(i).append(" "));

                System.out.println(sb);
                break;
            }

            for (Edge next : graph.get(now.node)) {
                int dist = now.weight + next.weight;

                if (distance[next.node] > dist) {
                    distance[next.node] = dist;

                    Edge edge = new Edge(next.node, dist);
                    edge.addPrevEdges(now);

                    queue.offer(edge);
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;
        List<Integer> prevEdges = new ArrayList<>();

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }

        public void addPrevEdges(Edge prev) {
            List<Integer> edges = new ArrayList<>(List.copyOf(prev.prevEdges));
            edges.add(this.node);
            this.prevEdges = edges;
        }
    }
}