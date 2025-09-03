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

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> poketmons = new HashMap<>();
        Map<Integer, String> numbers = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String poketmon = br.readLine();

            poketmons.put(poketmon, i);
            numbers.put(i, poketmon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String now = br.readLine();

            if (Character.isDigit(now.charAt(0))) {
                sb.append(numbers.get(Integer.parseInt(now)));
            } else {
                sb.append(poketmons.get(now));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
