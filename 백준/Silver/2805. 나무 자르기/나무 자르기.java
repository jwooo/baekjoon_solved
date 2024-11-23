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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;

        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if (trees[i] > end) {
                end = trees[i];
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] - mid > 0) {
                    sum += (trees[i] - mid);
                }
            }

            if (sum < m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }
}