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

    static int[] parents;

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            sb.append("Scenario ").append(tc + 1).append(":\n");

            int n = Integer.parseInt(br.readLine());
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                union(u, v);
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (find(u) == find(v)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rootX < rootY) {
                parents[rootY] = rootX;
            } else {
                parents[rootX] = rootY;
            }
        }
    }


}