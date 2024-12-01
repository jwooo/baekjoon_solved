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

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int minStartIndex = 0;
        int minEndIndex = end;

        long absSum = Math.abs(arr[start] + arr[end]);

        while (start < end) {
            if (Math.abs(arr[start] + arr[end]) < absSum) {
                minStartIndex = start;
                minEndIndex = end;

                absSum = Math.abs(arr[start] + arr[end]);
            }

            if (arr[start] + arr[end] > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(arr[minStartIndex] + " " + arr[minEndIndex]);
    }

}