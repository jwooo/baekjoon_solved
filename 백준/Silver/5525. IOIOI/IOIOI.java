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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int result = 0;
        int count = 0;

        for (int i = 1; i < m - 1; i++) {
            if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
                count++;

                if (count == n) {
                    result++;
                    count--;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}