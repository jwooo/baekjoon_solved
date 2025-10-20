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
        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] lengths = new int[s];
        long totalLength = 0;

        for (int i = 0; i < s; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
            totalLength += lengths[i];
        }

        long left = 1;
        long right = 1_000_000_000;
        long optimalLength = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid == 0) {
                left = 1;
                continue;
            }

            long count = 0;
            for (int len : lengths) {
                count += len / mid;
            }

            if (count >= c) {
                optimalLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long remainingLength = totalLength - (optimalLength * c);
        System.out.println(remainingLength);
    }
}