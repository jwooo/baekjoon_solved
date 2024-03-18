import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String words = br.readLine();
            for (int j = 0; j < n; j++) {
                if (words.charAt(j) == '0') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    queue.offer(Node.of(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            visited[nowNode.getY()][nowNode.getX()] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = nowNode.getY() + dy[i];
                int nextX = nowNode.getX() + dx[i];

                if (nextY >= 0 && nextY < m && nextX >= 0 && nextX < n) {
                    if (!visited[nextY][nextX] && map[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        queue.offer(Node.of(nextY, nextX));
                    }
                }
            }
        }

        boolean isCorrect = false;
        for (int i = m - 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    isCorrect = true;
                    break;
                }
            }
        }

        if (isCorrect) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static class Node {
        private int y;
        private int x;

        private Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public static Node of(int y, int x) {
            return new Node(y, x);
        }
    }
}