import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            extractWords(arr[i], words);
        }

        for (int col = 0; col < m; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < n; row++) {
                sb.append(arr[row][col]);
            }

            extractWords(sb.toString().toCharArray(), words);
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }

    private void extractWords(char[] line, List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (char c : line) {
            if (c != '#') {
                sb.append(c);
            } else {
                addWord(sb, words);
            }
        }

        addWord(sb, words);
    }

    private void addWord(StringBuilder sb, List<String> words) {
        if (sb.length() > 1) {
            words.add(sb.toString());
        }

        sb.setLength(0);
    }
}

