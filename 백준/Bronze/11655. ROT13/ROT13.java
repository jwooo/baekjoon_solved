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
        char[] arr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            sb.append(rot13(c));
        }

        System.out.println(sb);
    }

    private char rot13(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + 13) % 26);
        } else if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + 13) % 26);
        } else {
            return c;
        }
    }
}
