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
        int n;

        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            long globalMax = Long.MIN_VALUE;
            long localMax = 0;

            for (int i = 0; i < n; i++) {
                int now = Integer.parseInt(br.readLine());

                localMax += now;

                if (globalMax < localMax) {
                    globalMax = localMax;
                }

                if (localMax < 0) {
                    localMax = 0;
                }
            }

            sb.append(globalMax).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}