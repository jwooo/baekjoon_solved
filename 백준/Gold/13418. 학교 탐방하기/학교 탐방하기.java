import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((i, j) -> j.weight - i.weight);
        pq.offer(new Edge(0, 0));

        boolean[] visited = new boolean[v + 1];

        int minUphill = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.node]) {
                continue;
            }

            visited[now.node] = true;
            if (now.weight == 0 && now.node != 0) {
                minUphill++;
            }

            for (Edge next : graph.get(now.node)) {
                if (!visited[next.node]) {
                    pq.offer(next);
                }
            }
        }

        int maxUphill = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        visited = new boolean[v + 1];

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.node]) {
                continue;
            }

            visited[now.node] = true;
            if (now.weight == 0 && now.node != 0) {
                maxUphill++;
            }

            for (Edge next : graph.get(now.node)) {
                if (!visited[next.node]) {
                    pq.offer(next);
                }
            }
        }

        int answer = (maxUphill * maxUphill) - (minUphill * minUphill);
        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }

}
