import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] info = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            int leftCount = info[i - 1];
            int emptySpot = 0;

            for (int j = 0; j < n; j++) {
                if (emptySpot == leftCount && result[j] == 0) {
                    result[j] = i;
                    break;
                }

                if (result[j] == 0) {
                    emptySpot++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int person : result) {
            sb.append(person).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}