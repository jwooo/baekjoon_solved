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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int[] distances = dijkstra(graph);

        int hideNode = 1;
        int dist = 0;
        int nodeCount = 1;

        for (int i = 2; i < distances.length; i++) {
            if (dist > distances[i]) {
                continue;
            } else if (dist == distances[i]) {
                nodeCount++;
            } else {
                hideNode = i;
                dist = distances[i];
                nodeCount = 1;
            }
        }

        System.out.println(hideNode + " " + dist + " " + nodeCount);
    }

    private int[] dijkstra(List<List<Integer>> graph) {
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, 100_000_000);

        distances[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            if (i[1] == j[1]) {
                return i[0] - j[0];
            }

            return i[1] - j[1];
        });

        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int node = now[0];
            int dist = now[1];

            if (distances[node] < dist) {
                continue;
            }

            for (int next : graph.get(node)) {
                int nextDist = dist + 1;

                if (nextDist < distances[next]) {
                    distances[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }

        return distances;
    }

}