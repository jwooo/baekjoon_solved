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
        int party = Integer.parseInt(st.nextToken());

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

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i != party) {
                answer = Math.max(answer, comebackToParty(i, party, graph));
            }
        }

        System.out.println(answer);
    }

    public int comebackToParty(int start, int target, List<List<Edge>> graph) {
        return dijkstra(start, target, graph) + dijkstra(target, start, graph);
    }

    public int dijkstra(int start, int target, List<List<Edge>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (distance[edge.node] < edge.weight) {
                continue;
            }
            if (target == edge.node) {
                return distance[edge.node];
            }

            for (Edge next : graph.get(edge.node)) {
                int dist = edge.weight + next.weight;

                if (distance[next.node] > dist) {
                    distance[next.node] = dist;
                    queue.offer(new Edge(next.node, dist));
                }
            }
        }

        return 0;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

}