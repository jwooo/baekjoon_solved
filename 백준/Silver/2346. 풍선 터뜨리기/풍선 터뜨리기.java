import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            sb.append(now[0]).append(" ");

            if (deque.isEmpty()) {
                break;
            }
            int move = now[1];

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }


}