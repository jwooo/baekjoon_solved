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
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");

            if (parts.length < 2) {
                continue;
            }

            String s = parts[0];
            String t = parts[1];

            int sIndex = 0;
            int tIndex = 0;

            while (sIndex < s.length() && tIndex < t.length()) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    sIndex++;
                }

                tIndex++;
            }

            if (sIndex == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}