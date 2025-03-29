import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            Queue<Integer> minQueue = new PriorityQueue<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String event = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (event.equals("I")) {
                    maxQueue.offer(number);
                    minQueue.offer(number);

                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else {
                    if (number == 1) {
                        lazyCounting(map, maxQueue);
                    } else {
                        lazyCounting(map, minQueue);
                    }
                }
            }

            removeZero(map, maxQueue);
            removeZero(map, minQueue);

            if (maxQueue.isEmpty() && minQueue.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(maxQueue.poll()).append(" ").append(minQueue.poll());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private void lazyCounting(HashMap<Integer, Integer> map, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int now = queue.peek();
            int count = map.get(now);

            if (count == 0) {
                queue.poll();
            } else {
                map.put(now, count - 1);
                break;
            }
        }
    }

    private void removeZero(HashMap<Integer, Integer> map, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int now = queue.peek();
            int count = map.get(now);

            if (count == 0) {
                queue.poll();
            } else {
                break;
            }
        }
    }

}