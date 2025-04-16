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

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] tree = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] now = br.readLine().split(" ");

            int root = now[0].charAt(0) - 'A';
            int left = now[1].charAt(0) - 'A';
            int right = now[2].charAt(0) - 'A';

            tree[root][0] = left;
            tree[root][1] = right;
        }

        preOrder(0, tree);
        System.out.println();

        inOrder(0, tree);
        System.out.println();

        postOrder(0, tree);
        System.out.println();
    }

    private void preOrder(int now, int[][] tree) {
        if (now < 0) {
            return;
        }
        System.out.print((char) (now + 'A'));
        preOrder(tree[now][0], tree);
        preOrder(tree[now][1], tree);
    }

    private void inOrder(int now, int[][] tree) {
        if (now < 0) {
            return;
        }
        inOrder(tree[now][0], tree);
        System.out.print((char) (now + 'A'));
        inOrder(tree[now][1], tree);
    }

    private void postOrder(int now, int[][] tree) {
        if (now < 0) {
            return;
        }
        postOrder(tree[now][0], tree);
        postOrder(tree[now][1], tree);
        System.out.print((char) (now + 'A'));
    }

}