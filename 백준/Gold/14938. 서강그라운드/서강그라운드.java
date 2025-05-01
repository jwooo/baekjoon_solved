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
        int range = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());

        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int countItems = dijkstra(i, range, items, graph);
            answer = Math.max(answer, countItems);
        }

        System.out.println(answer);
    }

    public int dijkstra(int now, int range, int[] items, List<List<Edge>> graph) {
        int answer = 0;

        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[now] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(now, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (distance[edge.node] < edge.weight) {
                continue;
            }
            for (Edge e : graph.get(edge.node)) {
                int dist = edge.weight + e.weight;

                if (distance[e.node] > dist) {
                    distance[e.node] = dist;
                    queue.offer(new Edge(e.node, dist));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= range) {
                answer += items[i];
            }
        }

        return answer;
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