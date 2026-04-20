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

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        if (graph.get(1).isEmpty()) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int next : graph.get(now[0])) {
                if (!visited[next] && now[1] <= 2) {
                    answer++;
                    visited[next] = true;
                    q.offer(new int[]{next, now[0] + 1});
                }
            }
        }

        System.out.println(answer);
    }

}