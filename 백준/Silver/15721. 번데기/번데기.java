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

    static int A, T, WORD_TYPE;
    static int pIndex = 0;
    static int bCount = 0;
    static int dCount = 0;

    private static void processShout(int shouteWordType) {
        if (shouteWordType == 0) {
            bCount++;

            if (WORD_TYPE == 0 && bCount == T) {
                System.out.println(pIndex);
                System.exit(0);
            }
        } else {
            dCount++;

            if (WORD_TYPE == 1 && dCount == T) {
                System.out.println(pIndex);
                System.exit(0);
            }
        }

        pIndex = (pIndex + 1) % A;
    }

    public void solution() throws IOException {
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        WORD_TYPE = Integer.parseInt(br.readLine());

        int round = 2;
        int[] initialPattern = {0, 1, 0, 1};

        while (true) {
            for (int shoutType : initialPattern) {
                processShout(shoutType);
            }

            for (int i = 0; i < round; i++) {
                processShout(0);
            }

            for (int i = 0; i < round; i++) {
                processShout(1);
            }

            round++;
        }
    }
}
