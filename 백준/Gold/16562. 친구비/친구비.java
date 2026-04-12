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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int min = arr[i];
                visited[i] = true;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()) {
                    Integer now = q.poll();

                    for (Integer next : graph.get(now)) {
                        if (!visited[next]) {
                            int nextPrice = arr[next];
                            visited[next] = true;
                            q.offer(next);

                            min = Math.min(min, nextPrice);
                        }
                    }
                }

                answer += min;
            }
        }

        if (k < answer) {
            System.out.println("Oh no");
        } else {
            System.out.println(answer);
        }
    }

}