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
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isShine(mid, n, arr)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private boolean isShine(int height, int n, int[] arr) {
        if (arr[0] - height > 0) {
            return false;
        }

        int maxReach = arr[0] + height;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - height > maxReach) {
                return false;
            }

            maxReach = arr[i] + height;
        }

        return maxReach >= n;
    }

}