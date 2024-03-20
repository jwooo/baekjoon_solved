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

    void solution() throws IOException {
        while (true) {
            String n = br.readLine();
            boolean isFeline = true;

            if (n.equals("0")) {
                break;
            }

            if (n.length() % 2 == 0) {
                int startIndex = 0;
                int endIndex = n.length() - 1;

                while (startIndex < endIndex) {
                    if (!(n.charAt(startIndex) == n.charAt(endIndex))) {
                        isFeline = false;
                        break;
                    }

                    startIndex++;
                    endIndex--;
                }
            } else {
                int startIndex = 0;
                int endIndex = n.length() - 1;

                while (startIndex < endIndex) {
                    if (!(n.charAt(startIndex) == n.charAt(endIndex))) {
                        isFeline = false;
                        break;
                    }

                    startIndex++;
                    endIndex--;
                }
            }

            if (isFeline) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}