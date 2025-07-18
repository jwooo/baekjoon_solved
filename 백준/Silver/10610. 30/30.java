import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        char[] digits = br.readLine().toCharArray();

        int sum = 0;
        boolean hasZero = false;

        for (char digit : digits) {
            int now = digit - '0';
            sum += now;

            if (now == 0) {
                hasZero = true;
            }
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(digits);

            StringBuilder sb = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }

            System.out.println(sb);
        }
    }

}
