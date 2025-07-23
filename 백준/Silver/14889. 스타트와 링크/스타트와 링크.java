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

    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private void dfs(int depth, int now) {
        if (depth == n / 2) {
            int teamA = 0;
            int teamB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        teamA += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        teamB += arr[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(teamA - teamB));
        }

        for (int i = now; i < n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}
