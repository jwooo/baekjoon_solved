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

        System.out.println(dijkstra(start, target, graph));
    }

    public int dijkstra(int start, int target, List<List<Edge>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (now.weight > distance[now.node]) {
                continue;
            }
            if (now.node == target) {
                return distance[now.node];
            }

            for (Edge edge : graph.get(now.node)) {
                int dist = now.weight + edge.weight;

                if (dist < distance[edge.node]) {
                    distance[edge.node] = dist;
                    queue.offer(new Edge(edge.node, dist));
                }
            }
        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {
        private int node;
        private int weight;

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