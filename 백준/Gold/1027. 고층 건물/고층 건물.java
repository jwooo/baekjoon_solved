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
        int n = Integer.parseInt(br.readLine());

        int[] buildings = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int currentCount = 0;

            double maxSlopedLeft = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (buildings[i] - buildings[j]) / (i - j);

                if (slope < maxSlopedLeft) {
                    currentCount++;
                    maxSlopedLeft = slope;
                }
            }

            double maxSlopedRight = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < n; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);

                if (slope > maxSlopedRight) {
                    currentCount++;
                    maxSlopedRight = slope;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        System.out.println(maxCount);
    }
}
