import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a != b) {
                return Integer.compare(a, b);
            } else {
                return Integer.compare(o1, o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now != 0) {
                queue.offer(now);
            } else {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
    
}