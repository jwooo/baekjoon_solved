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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int cycleSequence = -1;
        boolean hasCycle = false;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (hasCycle) {
                continue;
            }
            if (isCycle(a, b)) {
                cycleSequence = i + 1;
                hasCycle = true;
            }
        }

        cycleSequence = cycleSequence != -1 ? cycleSequence : 0;
        System.out.println(cycleSequence);
    }

    private boolean isCycle(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        } else {
            parent[b] = a;
            return false;
        }
    }

    private int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}
