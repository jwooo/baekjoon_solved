import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void solution() throws IOException {
        int n = -1;
        StringBuilder sb = new StringBuilder();

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            Map<String, String> map = new HashMap<>();
            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                words[i] = word.toLowerCase();
                map.put(words[i], word);
            }

            Arrays.sort(words);
            sb.append(map.get(words[0])).append("\n");
        }

        System.out.println(sb);
    }
}
