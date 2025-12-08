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

        long[] distances = new long[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        long[] prices = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minPrice = prices[0];

        totalCost += minPrice * distances[0];
        for (int i = 1; i < n - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            totalCost += minPrice * distances[i];
        }

        System.out.println(totalCost);
    }
}