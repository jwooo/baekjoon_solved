import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int maxDeadLine = 0;

        int[][] schedules = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            schedules[i][0] = deadLine;
            schedules[i][1] = count;

            maxDeadLine = Math.max(maxDeadLine, deadLine);
        }

        Arrays.sort(schedules, (i, j) -> {
            if (i[0] == j[0]) {
                return i[1] - j[1];
            }

            return i[0] - j[0];
        });

        int answer = 0;
        int index = n - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = maxDeadLine; i >= 1; i--) {
            while (index >= 0 && schedules[index][0] >= i) {
                pq.offer(schedules[index][1]);
                index--;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}