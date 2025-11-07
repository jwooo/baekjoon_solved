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

    public Main() {
    }

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

            graph.get(end).add(start);
        }

        List<int[]> answers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int count = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            boolean[] visited = new boolean[n + 1];
            visited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (Integer next : graph.get(now)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        count++;
                    }
                }
            }

            answers.add(new int[]{i, count});
        }

        answers.sort((i, j) -> {
            if (i[1] == j[1]) {
                return i[0] - j[0];
            }

            return j[1] - i[1];
        });

        StringBuilder sb = new StringBuilder();
        sb.append(answers.get(0)[0]).append(" ");

        for (int i = 1; i < answers.size(); i++) {
            if (answers.get(i)[1] == answers.get(0)[1]) {
                sb.append(answers.get(i)[0]).append(" ");
            } else {
                break;
            }
        }

        System.out.println(sb.toString().trim());
    }

}