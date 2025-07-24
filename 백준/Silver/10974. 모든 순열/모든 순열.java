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

    static int n;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        dfs(0, new int[n]);
        System.out.println(sb);
    }

    private void dfs(int depth, int[] checked) {
        if (depth == n) {
            for (int i = 0; i < checked.length; i++) {
                sb.append(checked[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                checked[depth] = i + 1;

                dfs(depth + 1, checked);

                visited[i] = false;
                checked[depth] = 0;
            }
        }
    }

}
