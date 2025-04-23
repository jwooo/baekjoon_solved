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
        int e = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int firstDistance = getAnswer(first, second, n, graph);
        int secondDistance = getAnswer(second, first, n, graph);

        int answer = -1;
        if (firstDistance != -1 && secondDistance != -1) {
            answer = Math.min(firstDistance, secondDistance);
        } else if (firstDistance == -1) {
            answer = secondDistance;
        } else if (secondDistance == -1) {
            answer = firstDistance;
        }

        System.out.println(answer);
    }

    public int getAnswer(int first, int second, int n, List<List<Edge>> graph) {
        int firstDistance = dijkstra(1, first, 0, graph);
        int secondDistance = dijkstra(first, second, firstDistance, graph);
        int answer = dijkstra(second, n, secondDistance, graph);

        if (firstDistance == -1 || secondDistance == -1 || answer == -1) {
            return -1;
        } else {
            return answer;
        }
    }

    public int dijkstra(int start, int target, int d, List<List<Edge>> graph) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = d;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(start, d));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (distance[now.node] < now.weight) {
                continue;
            }
            if (now.node == target) {
                return now.weight;
            }
            for (Edge next : graph.get(now.node)) {
                int nextDistance = now.weight + next.weight;
                if (distance[next.node] > nextDistance) {
                    distance[next.node] = nextDistance;
                    queue.offer(new Edge(next.node, nextDistance));
                }
            }
        }

        return -1;
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
    }
}