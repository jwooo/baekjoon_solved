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
        String word = br.readLine();
        System.out.println(isValid(word) ? 1 : 0);
    }

    private static boolean isValid(String word) {
        int n = word.length();
        if (n < 4) {
            return false;
        }

        int index = 0;
        while (index < n) {
            int wCount = 0;

            while (index < n && word.charAt(index) == 'w') {
                wCount++;
                index++;
            }

            if (wCount == 0) {
                return false;
            }

            for (int i = 0; i < wCount; i++) {
                if (index >= n || word.charAt(index) != 'o') {
                    return false;
                }

                index++;
            }

            for (int i = 0; i < wCount; i++) {
                if (index >= n || word.charAt(index) != 'l') {
                    return false;
                }

                index++;
            }

            for (int i = 0; i < wCount; i++) {
                if (index >= n || word.charAt(index) != 'f') {
                    return false;
                }

                index++;
            }
        }

        return index == n;
    }

}