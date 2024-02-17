import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int value, int parent) {
        for (int i : list[value]) {
            if (parent == i) continue;
            result[i] = value;
            dfs(i, value);
        }
    }
}