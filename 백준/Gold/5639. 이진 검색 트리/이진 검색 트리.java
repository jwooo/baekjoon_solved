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
        Node root = new Node();
        root.setNode(Integer.parseInt(br.readLine()));

        Tree tree = new Tree(root);

        while (true) {
            String node = br.readLine();
            if (node == null || node.isEmpty()) {
                break;
            }
            tree.add(Integer.parseInt(node));
        }

        tree.postOrder();
    }

    static class Node {
        int node;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int node) {
            this.node = node;
        }

        public void setNode(int node) {
            this.node = node;
        }
    }

    static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void postOrder() {
            postOrder(root);
        }

        private void postOrder(Node now) {
            if (now == null) {
                return;
            }
            postOrder(now.left);
            postOrder(now.right);
            System.out.println(now.node);
        }

        public void add(int now) {
            if (root.node > now) {
                if (root.left == null) {
                    root.left = new Node(now);
                } else {
                    add(root.left, now);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(now);
                } else {
                    add(root.right, now);
                }
            }
        }

        public void add(Node parent, int now) {
            if (parent.node > now) {
                if (parent.left == null) {
                    parent.left = new Node(now);
                } else {
                    add(parent.left, now);
                }
            } else {
                if (parent.right == null) {
                    parent.right = new Node(now);
                } else {
                    add(parent.right, now);
                }
            }
        }
    }
}