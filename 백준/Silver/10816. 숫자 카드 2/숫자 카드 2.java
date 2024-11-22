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
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();

        readLine();

        for (int i = 0; i < n; i++) {
            Integer card = Integer.parseInt(st.nextToken());

            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());

            sb.append(cards.getOrDefault(card, 0)).append(' ');
        }

        System.out.println(sb);
    }

    private static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine());
    }
}