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
        int m = Integer.parseInt(br.readLine());

        ArrayList[] graph = new ArrayList[n + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            List<Integer> links = graph[now];

            for (int link : links) {
                if (!visited[link]) {
                    visited[link] = true;
                    count++;
                    queue.offer(link);
                }
            }
        }

        System.out.println(count);
    }

}