import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static final int MAX = 100_000;
    static int[] parent = new int[MAX + 1];
    static boolean[] visited = new boolean[MAX + 1];

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        bfs(n, m);
    }

    public void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now + 1, now - 1, now * 2}) {
                if (next < 0 || next > MAX) {
                    continue;
                }
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                parent[next] = now;

                if (next == end) {
                    printPath(next);
                    return;
                }

                queue.offer(next);
            }
        }
    }

    private void printPath(int target) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(target);

        while (parent[target] != -1) {
            target = parent[target];
            stack.push(target);
        }

        sb.append(stack.size() - 1).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}
