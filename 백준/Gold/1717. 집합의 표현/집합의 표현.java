import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int event = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (event == 0) {
                union(start, end, parent);
            } else {
                if (isSameParent(start, end, parent)) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private void union(int start, int end, int[] parent) {
        start = find(start, parent);
        end = find(end, parent);

        if (start != end) {
            parent[end] = start;
        }
    }

    private int find(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    private boolean isSameParent(int first, int second, int[] parent) {
        return find(first, parent) == find(second, parent);
    }
}
