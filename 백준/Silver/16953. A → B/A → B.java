import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        dfs(start, end, 0);

        if (answer == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer + 1);
        }
    }

    private void dfs(long now, long end, int count) {
        if (now == end) {
            answer = Math.min(answer, count);
            return;
        } else if (now > end) {
            return;
        }

        dfs(now * 2, end, count + 1);
        dfs(now * 10 + 1, end, count + 1);
    }

}