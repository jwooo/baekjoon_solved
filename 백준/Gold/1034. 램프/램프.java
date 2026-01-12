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

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        int max = 0;
        int k = Integer.parseInt(br.readLine());
        for (String key : map.keySet()) {
            int c = 0;
            for (int i = 0; i < key.length(); i++) {
                int now = key.charAt(i) - '0';
                if (now == 0) {
                    c++;
                }
            }

            if (k < c) {
                continue;
            }
            if ((k - c) % 2 == 0) {
                max = Math.max(max, map.get(key));
            }
        }

        System.out.println(max);
    }

}
