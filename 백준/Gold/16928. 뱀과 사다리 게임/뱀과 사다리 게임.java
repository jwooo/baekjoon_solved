import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int ladderCount = Integer.parseInt(st.nextToken());
        int snakeCount = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();

        for (int i = 0; i < ladderCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladders.put(start, end);
        }

        for (int i = 0; i < snakeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snakes.put(start, end);
        }

        bfs(1, 0, ladders, snakes);
        System.out.println(answer);
    }

    private void bfs(int now, int count, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{now, count});

        boolean[] visited = new boolean[101];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] entry = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = entry[0] + i;

                if (ladders.containsKey(next)) next = ladders.get(next);
                else if (snakes.containsKey(next)) next = snakes.get(next);

                if (next > 100) continue;
                if (!visited[next]) {
                    if (next == 100) {
                        answer = entry[1] + 1;
                        return;
                    }
                    
                    visited[next] = true;
                    queue.offer(new int[] {next, entry[1] + 1});
                }
            }
        }
    }
}