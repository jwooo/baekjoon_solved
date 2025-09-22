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

    static List<Integer>[] tree;
    static int removeNode;
    static int leafCount = 0;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        removeNode = Integer.parseInt(br.readLine());

        if (removeNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    private static void dfs(int node) {
        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (child == removeNode) {
                continue;
            }

            isLeaf = false;
            dfs(child);
        }

        if (isLeaf) {
            leafCount++;
        }
    }

}
