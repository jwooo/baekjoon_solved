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


    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, 1));
            graph.get(e).add(new Node(s, 1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] distances = new int[n + 1];
        Arrays.fill(distances, 10_000_001);
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.weight > distances[now.node]) {
                continue;
            }

            for (Node next : graph.get(now.node)) {
                int nextDistance = now.weight + next.weight;

                if (nextDistance < distances[next.node]) {
                    pq.offer(new Node(next.node, nextDistance));
                    distances[next.node] = nextDistance;
                }
            }
        }

        if (distances[end] == 10_000_001) {
            System.out.println(-1);
        } else {
            System.out.println(distances[end]);
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

}