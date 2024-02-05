import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int startIndex = 0;
        int endIndex = startIndex + x-1;
        int max = 0;
        int count = 0;
        int sum = 0;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = startIndex; i < startIndex+x; i++) {
            sum += arr[i];
        }
        max = sum;
        count++;

        while (endIndex < n-1) {
            endIndex++;
            sum -= arr[startIndex++];
            sum += arr[endIndex];

            if (sum == max) count++;
            else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }
}