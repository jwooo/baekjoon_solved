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
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            String initial = br.readLine();
            String target = br.readLine();

            int wToB = 0;
            int bToW = 0;

            for (int i = 0; i < n; i++) {
                if (initial.charAt(i) != target.charAt(i)) {
                    if (initial.charAt(i) == 'W') {
                        wToB++;
                    } else {
                        bToW++;
                    }
                }
            }

            int result = Math.max(wToB, bToW);
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}