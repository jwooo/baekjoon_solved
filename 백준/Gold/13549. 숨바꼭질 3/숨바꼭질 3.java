import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        queue.offer(new int[]{n, 0});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowIndex = now[0];
            count = now[1];

            if (nowIndex == k) break;

            visited[nowIndex] = true;
            if (nowIndex * 2 <= 100_000 && !visited[nowIndex * 2]) {
                queue.offer(new int[] {nowIndex * 2, count});
            }

            if (nowIndex < k && nowIndex + 1 <= 100_000 && !visited[nowIndex + 1]) {
                queue.offer(new int[] {nowIndex + 1, count + 1});
            }

            if (nowIndex - 1 >= 0 && !visited[nowIndex - 1]) {
                queue.offer(new int[] {nowIndex - 1, count + 1});
            }
        }

        System.out.println(count);
    }
}
