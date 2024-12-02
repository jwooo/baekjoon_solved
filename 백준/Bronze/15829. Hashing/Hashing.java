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
        // given
        int n = Integer.parseInt(br.readLine());
        int r = 31;
        int m = 1234567891;
        long pow = 1;
        String text = br.readLine();

        // when
        long result = 0;

        for (int i = 0; i < n; i++) {
            result += ((text.charAt(i) - 'a' + 1) * pow) % m;
            pow = (pow * r) % m;
        }

        // then
        System.out.println(result % m);
    }

}