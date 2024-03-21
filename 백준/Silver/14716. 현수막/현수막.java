import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(Node.of(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node nowNode = queue.poll();
                        visited[nowNode.getY()][nowNode.getX()] = true;

                        for (int k = 0; k < 8; k++) {
                            int nextY = nowNode.getY() + dy[k];
                            int nextX = nowNode.getX() + dx[k];

                            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                                if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                                    visited[nextY][nextX] = true;
                                    queue.offer(Node.of(nextY, nextX));
                                }
                            }
                        }
                    }

                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
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