import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static boolean[] visited;
    static boolean[] isCycle;
    static int[] distance;
    static List<List<Integer>> graph;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        visited = new boolean[n + 1];
        isCycle = new boolean[n + 1];
        distance = new int[n + 1];

        int[] path = new int[n + 1];
        Arrays.fill(path, -1);

        detectCycle(1, 0, path);
        getDistance();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(distance[i]).append(" ");
        }

        System.out.println(sb);
    }

    private boolean detectCycle(int now, int parent, int[] path) {
        visited[now] = true;
        path[now] = parent;

        for (int next : graph.get(now)) {
            if (parent == next) {
                continue;
            }
            if (visited[next]) {
                int cycleNode = now;

                while (cycleNode != next) {
                    isCycle[cycleNode] = true;
                    cycleNode = path[cycleNode];
                }

                isCycle[next] = true;
                return true;
            } else {
                if (detectCycle(next, now, path)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void getDistance() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) {
                queue.offer(i);
            } else {
                distance[i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
