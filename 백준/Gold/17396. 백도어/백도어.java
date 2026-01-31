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

    static int n;
    static int m;
    static boolean[] isVisible;
    static List<List<Node>> nodes = new ArrayList<>();

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        isVisible = new boolean[n];

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (now == 0) {
                isVisible[i] = false;
            } else {
                isVisible[i] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end, distance));
            nodes.get(end).add(new Node(start, distance));
        }

        long minDistance = dijkstra();
        System.out.println(minDistance);
    }

    private long dijkstra() {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.weight > dist[node.node]) {
                continue;
            }

            for (Node next : nodes.get(node.node)) {
                long nextDistance = node.weight + next.weight;

                if (next.node != n - 1 && isVisible[next.node]) {
                    continue;
                }

                if (nextDistance < dist[next.node]) {
                    pq.offer(new Node(next.node, nextDistance));
                    dist[next.node] = nextDistance;
                }
            }
        }

        return dist[n - 1] != Long.MAX_VALUE ? dist[n - 1] : -1;
    }

    static class Node implements Comparable<Node> {
        int node;
        long weight;

        public Node(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }

    }

}