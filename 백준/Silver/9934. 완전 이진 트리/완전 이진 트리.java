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
    static int[] arr;
    static Node root;
    static List<StringBuilder> levelNodes = new ArrayList<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[(int) (Math.pow(2, n) - 1)];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            levelNodes.add(new StringBuilder());
        }

        dfs(0, arr.length - 1, root);
        printByLevel(root, 0);

        for (StringBuilder levelNode : levelNodes) {
            System.out.println(levelNode.toString().trim());
        }
    }

    private static void printByLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        levelNodes.get(level).append(node.node).append(" ");

        printByLevel(node.left, level + 1);
        printByLevel(node.right, level + 1);
    }

    private static void dfs(int start, int end, Node parent) {
        if (start == end) {
            if (parent == null) {
                parent = new Node(arr[start]);
                root = parent;
            } else {
                parent.add(new Node(arr[start]));
            }

            return;
        }

        int mid = (start + end) / 2;
        Node now = new Node(arr[mid]);

        if (parent == null) {
            parent = now;
            root = parent;
        } else {
            parent.add(now);
        }

        dfs(start, mid - 1, now);
        dfs(mid + 1, end, now);
    }

    static class Node {
        int node;
        Node left;
        Node right;

        public Node(int node) {
            this.node = node;
        }

        public void add(Node child) {
            if (left == null) {
                left = child;
            } else {
                right = child;
            }
        }
    }
}