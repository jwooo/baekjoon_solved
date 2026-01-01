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

    static int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, numbers[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= min; i++) {
            if (!isCommonDivisor(i, numbers)) {
                continue;
            }

            sb.append(i).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private boolean isCommonDivisor(int now, int[] arr) {
        for (int j : arr) {
            if (j % now != 0) {
                return false;
            }
        }

        return true;
    }
}
