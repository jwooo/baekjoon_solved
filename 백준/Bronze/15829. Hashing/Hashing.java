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
        String text = br.readLine();

        // when
        int result = 0;

        for (int i = 0; i < n; i++) {
            int value = text.charAt(i) - 'a' + 1;
            result = result + (value * (int) Math.pow(31, i));
        }

        // then
        System.out.println(result);
    }

}