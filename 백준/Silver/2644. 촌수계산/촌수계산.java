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
    static int start;
    static int end;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int answer = -1;


    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        visited = new boolean[n + 1];
        find(start, 0);

        System.out.println(answer);
    }

    static void find(int now, int count) {
        visited[now] = true;

        if (now == end) {
            answer = count;
            return;
        }

        for (int next : graph.get(now)) {
            if (!visited[next]) {
                find(next, count + 1);
            }
        }
    }
}