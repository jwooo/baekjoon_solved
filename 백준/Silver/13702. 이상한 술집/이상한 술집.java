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

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long start = 0;
        long end = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (arr[i] > end) {
                start = arr[i] / k;
                end = arr[i];
            }
        }

        while (start <= end) {
            long mid = (start + end) / 2;

            long result = divide(mid, arr);
            if (result >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start - 1);
    }

    private long divide(long mid, int[] arr) {
        long count = 0;

        for (int i : arr) {
            count += i / mid;
        }

        return count;
    }

}