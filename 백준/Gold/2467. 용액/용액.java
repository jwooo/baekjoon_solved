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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = arr.length - 1;

        int min = Integer.MAX_VALUE;
        int[] index = new int[2];

        while (start < end) {
            int startValue = arr[start];
            int endValue = arr[end];

            int absoluteSum = Math.abs(startValue + endValue);

            if (absoluteSum <= min) {
                min = absoluteSum;
                index = new int[]{startValue, endValue};
            }

            if (Math.abs(startValue) >= Math.abs(endValue)) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(index[0] + " " + index[1]);
    }

}
