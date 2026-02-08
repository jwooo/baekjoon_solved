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
    static long answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 1, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int now, int count, long cost) {
        if (count == n) {
            if (arr[now][start] != 0) {
                cost += arr[now][start];
                answer = Math.min(answer, cost);
            }

            return;
        }

        if (cost >= answer) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, count + 1, cost + arr[now][i]);
                visited[i] = false;
            }
        }
    }

}