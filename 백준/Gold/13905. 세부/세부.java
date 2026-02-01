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

    static final int DEFAULT = -1;
    static int n;
    static int m;
    static int start;
    static int end;
    static List<List<Node>> graph = new ArrayList<>();

    public void solution() throws IOException {
        init();
        int answer = process();
        System.out.println(answer);
    }

    private void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }
    }

    private int process() {
        int[] distances = new int[n + 1];

        distances[start] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.weight < distances[node.index]) {
                continue;
            }

            for (Node next : graph.get(node.index)) {
                int nextWeight = Math.min(node.weight, next.weight);

                if (nextWeight > distances[next.index]) {
                    pq.offer(new Node(next.index, nextWeight));
                    distances[next.index] = nextWeight;
                }
            }
        }

        return distances[end];
    }

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return Integer.compare(o.weight, this.weight);
        }
    }

}