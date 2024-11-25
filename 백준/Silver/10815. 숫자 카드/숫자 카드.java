import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int findNumber = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                int mid = (start + end) / 2;

                if (arr[mid] < findNumber) {
                    start = mid + 1;
                } else if (arr[mid] > findNumber) {
                    end = mid - 1;
                } else {
                    start = mid;
                    break;
                }
            }

            if (arr[start] == findNumber) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }

}