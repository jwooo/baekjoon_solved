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
        st = new StringTokenizer(br.readLine());

        int answer = Integer.MAX_VALUE;
        int answerValue = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList[] graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    count += bfs(i, j, graph);
                }
            }

            if (answerValue > count) {
                answerValue = count;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private int bfs(int start, int target, List[] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        boolean[] visited = new boolean[graph.length];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            List<Integer> link = graph[now[0]];

            for (int i = 0; i < link.size(); i++) {
                int linkNode = link.get(i);

                if (linkNode == target) {
                    return now[1] + 1;
                }
                if (!visited[linkNode]) {
                    queue.offer(new int[]{linkNode, now[1] + 1});
                    visited[linkNode] = true;
                }
            }
        }

        return 0;
    }

}