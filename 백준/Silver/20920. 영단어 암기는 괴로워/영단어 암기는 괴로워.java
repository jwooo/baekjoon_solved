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

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> words = new ArrayList<>();
        Map<String, Integer> notes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() < m) {
                continue;
            }

            if (!notes.containsKey(word)) {
                words.add(word);
            }

            notes.put(word, notes.getOrDefault(word, 0) + 1);
        }

        words.sort((i, j) -> {
            if (!notes.get(i).equals(notes.get(j))) {
                return notes.get(j) - notes.get(i);
            }

            if (i.length() != j.length()) {
                return j.length() - i.length();
            }

            return i.compareTo(j);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}