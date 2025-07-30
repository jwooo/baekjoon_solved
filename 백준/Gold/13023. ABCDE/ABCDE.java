import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i < n; i++) {
            if (dfs(i, 0)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private boolean dfs(int now, int depth) {
        if (depth == 4) {
            return true;
        }

        visited[now] = true;

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                if (dfs(next, depth + 1)) {
                    return true;
                }
            }
        }

        visited[now] = false;

        return false;
    }
}
