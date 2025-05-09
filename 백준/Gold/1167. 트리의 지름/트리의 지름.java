import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Edge>> tree = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree.get(node).add(new Edge(next, w));
            }
        }

        int u = bfsFindFarthest(1, tree, N);
        int diameter = bfsDistance(u, tree, N);

        System.out.println(diameter);
    }

    private static int bfsFindFarthest(int start, List<List<Edge>> tree, int N) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        q.offer(start);
        visited[start] = true;

        int farthestNode = start;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : tree.get(cur)) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[cur] + e.weight;
                    q.offer(e.to);
                    if (dist[e.to] > dist[farthestNode]) {
                        farthestNode = e.to;
                    }
                }
            }
        }
        return farthestNode;
    }

    private static int bfsDistance(int start, List<List<Edge>> tree, int N) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        q.offer(start);
        visited[start] = true;

        int maxDist = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : tree.get(cur)) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[cur] + e.weight;
                    q.offer(e.to);
                    if (dist[e.to] > maxDist) {
                        maxDist = dist[e.to];
                    }
                }
            }
        }
        return maxDist;
    }
}
