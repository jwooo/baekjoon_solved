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

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break;
            int startIndex = i + 1;
            int endIndex = n - 1;

            while (startIndex < endIndex) {
                int s = 1;
                int e = 1;

                int now = arr[i] + arr[startIndex] + arr[endIndex];
                if (now == 0) {
                    if (arr[startIndex] == arr[endIndex]) {
                        ans += combination(endIndex - startIndex + 1);
                        break;
                    }

                    while (startIndex + 1 < endIndex && arr[startIndex] == arr[startIndex + 1]) {
                        s++;
                        startIndex++;
                    }

                    while (startIndex < endIndex - 1 && arr[endIndex] == arr[endIndex - 1]) {
                        e++;
                        endIndex--;
                    }

                    ans += s * e;
                }

                if (now > 0) endIndex--;
                else startIndex++;
            }
        }

        System.out.println(ans);
    }

    public static long combination(int n) {
        return n * (n - 1) / 2;
    }
}