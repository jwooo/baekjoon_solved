import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

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

        int firstIndex = 0;
        int secondIndex = 0;
        int min = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = n - 1;

        while (startIndex < endIndex) {
            int sum = arr[startIndex] + arr[endIndex];

            if (Math.abs(sum) <= min) {
                min = Math.abs(sum);
                firstIndex = startIndex;
                secondIndex = endIndex;
            }

            if (sum < 0) {
                startIndex++;
            } else if (sum > 0) {
                endIndex--;
            } else {
                break;
            }
        }

        System.out.println(arr[firstIndex] + " " + arr[secondIndex]);
    }
}