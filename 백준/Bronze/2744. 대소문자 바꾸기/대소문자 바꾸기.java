import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        char[] words = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char c = words[i];

            if (c >= 'A' && c <= 'Z') {
                c = (char) ('a' + c - 'A');
            } else {
                c = (char) ('A' + c - 'a');
            }

            sb.append(c);
        }

        System.out.println(sb);
    }
}
