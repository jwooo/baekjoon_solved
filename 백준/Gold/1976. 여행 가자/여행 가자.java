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

    static int[] parent;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int isConnection = Integer.parseInt(st.nextToken());

                if (i == j) {
                    continue;
                }
                if (isConnection == 1) {
                    union(i, j);
                }
            }
        }

        int[] path = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        boolean isRightPath = true;
        for (int i = 0; i < m; i++) {
            if (!isSame(path[0], path[i])) {
                isRightPath = false;
                break;
            }
        }

        if (isRightPath) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private int find(int now) {
        if (now == parent[now]) {
            return now;
        }

        return find(parent[now]);
    }

    private boolean isSame(int a, int b) {
        return find(a) == find(b);
    }

}
