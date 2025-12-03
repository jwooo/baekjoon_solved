import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String line = br.readLine();

        int n = 0;
        int ptr = 0;

        while (ptr < line.length()) {
            String nLine = String.valueOf(++n);

            for (int i = 0; i < nLine.length(); i++) {
                if (line.charAt(ptr) == nLine.charAt(i)) {
                    ptr++;
                }

                if (ptr == line.length()) {
                    break;
                }
            }
        }

        System.out.println(n);
    }
}