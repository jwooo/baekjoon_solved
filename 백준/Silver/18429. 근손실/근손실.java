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
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int answer;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        answer = 0;
        dfs(500, 0);
        System.out.println(answer);
    }

    private static void dfs(int sum, int index) {
        if (index == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (sum + arr[i] - m) >= 500) {
                visited[i] = true;
                dfs(sum + arr[i] - m, index + 1);
                visited[i] = false;
            }
        }
    }
}