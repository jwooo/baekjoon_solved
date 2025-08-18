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
        String n = br.readLine();
        String m = br.readLine();

        int answer = canTranslate(n, m) ? 1 : 0;
        System.out.println(answer);
    }

    private boolean canTranslate(String n, String m) {
        if (n.length() == m.length()) {
            return n.equals(m);
        }

        if (m.charAt(m.length() - 1) == 'A') {
            if (canTranslate(n, m.substring(0, m.length() - 1))) {
                return true;
            }
        }

        if (m.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(m.substring(1));
            if (canTranslate(n, sb.reverse().toString())) {
                return true;
            }
        }

        return false;
    }

}
