import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
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

        st = new StringTokenizer(br.readLine());

        int ctpNode = Integer.parseInt(st.nextToken());
        int hansolNode = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(hansolNode, visited, graph);
        int answer = bfs(ctpNode, visited, graph);

        List<Integer> powers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                powers.add(bfs(i, visited, graph));
            }
        }

        powers.sort(Collections.reverseOrder());
        int index = 0;
        for (int i = 0; i < k; i++) {
            answer += powers.get(index++);
        }

        System.out.println(answer);
    }

    private static int bfs(int findNode, boolean[] visited, List<List<Integer>> graph) {
        int power = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(findNode);

        visited[findNode] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    power++;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return power;
    }

}