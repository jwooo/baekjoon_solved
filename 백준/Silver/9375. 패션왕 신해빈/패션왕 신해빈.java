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

    void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int answer = 1;
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String clothes = st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 1) + 1);
            }

            for (String clothes : map.keySet()) {
                answer *= map.get(clothes);
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }

}