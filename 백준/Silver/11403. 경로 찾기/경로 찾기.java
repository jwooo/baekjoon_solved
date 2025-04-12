import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList[] graph = new ArrayList[n + 1];
        int[][] answer = new int[n + 1][n + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int link = Integer.parseInt(st.nextToken());

                if (link == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bfs(i, graph, answer);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private void bfs(int start, List[] graph, int[][] answer) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[answer.length];

        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> links = graph[now];

            for (int link : links) {
                if (!visited[link]) {
                    answer[start][link] = 1;
                    queue.offer(link);
                    visited[link] = true;
                }
            }
        }
    }
}
