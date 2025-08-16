import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int d;
    static int k;
    static int c;
    static int answer;
    static int[] sushiBelt;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushiBelt = new int[n];
        for (int i = 0; i < n; i++) {
            sushiBelt[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < k; i++) {
            visited.put(sushiBelt[i], visited.getOrDefault(sushiBelt[i], 0) + 1);
        }
        answer = visited.containsKey(c) ? visited.size() : visited.size() + 1;

        int index = 1;
        while (index < n) {
            int removeIndex = index - 1;
            int removeCount = visited.get(sushiBelt[removeIndex]);

            int addIndex = (index + k - 1) % n;

            if (removeCount == 1) {
                visited.remove(sushiBelt[removeIndex]);
            } else {
                visited.put(sushiBelt[removeIndex], removeCount - 1);
            }

            visited.put(sushiBelt[addIndex], visited.getOrDefault(sushiBelt[addIndex], 0) + 1);

            int types = visited.containsKey(c) ? visited.size() : visited.size() + 1;
            answer = Math.max(answer, types);

            index++;
        }

        System.out.println(answer);
    }


}
