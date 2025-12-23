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
        char[] lines = br.readLine().toCharArray();

        int continueZeros = 0;
        boolean isPrevZero = false;

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == '0') {
                if (!isPrevZero) {
                    continueZeros++;
                }

                isPrevZero = true;
            } else {
                isPrevZero = false;
            }
        }

        int continueOnes = 0;
        boolean isPrevOne = false;

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == '1') {
                if (!isPrevOne) {
                    continueOnes++;
                }

                isPrevOne = true;
            } else {
                isPrevOne = false;
            }
        }

        System.out.println(Math.min(continueZeros, continueOnes));
    }
}
