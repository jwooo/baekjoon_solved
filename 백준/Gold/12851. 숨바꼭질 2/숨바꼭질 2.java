import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MAX = 100000;
        int[] dist = new int[MAX + 1];
        long[] ways = new long[MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<>();
        dist[N] = 0;
        ways[N] = 1;
        q.add(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur];
            if (d > dist[K]) {
                break;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nxt : nexts) {
                if (nxt < 0 || nxt > MAX) {
                    continue;
                }
                if (dist[nxt] == Integer.MAX_VALUE) {
                    dist[nxt] = d + 1;
                    ways[nxt] = ways[cur];
                    q.add(nxt);
                } else if (dist[nxt] == d + 1) {
                    ways[nxt] += ways[cur];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}