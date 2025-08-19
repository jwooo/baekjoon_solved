import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            char[] question = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            Map<Character, List<Integer>> history = new HashMap<>();
            for (int i = 0; i < question.length; i++) {
                char now = question[i];

                if (!history.containsKey(now)) {
                    history.put(now, new ArrayList<>());
                }

                history.get(now).add(i);
            }

            for (int i = 0; i < question.length; i++) {
                char now = question[i];
                List<Integer> hist = history.get(now);

                if (hist.size() < k) {
                    hist.remove(0);
                    continue;
                }

                int range = hist.get(k - 1) + 1 - i;

                min = Math.min(min, range);
                max = Math.max(max, range);

                hist.remove(0);
            }

            createAnswer(min, max, sb);
        }

        System.out.println(sb);
    }

    private void createAnswer(int min, int max, StringBuilder sb) {
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            sb.append(-1).append("\n");
        } else {
            sb.append(min).append(" ").append(max).append("\n");
        }
    }

}
