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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] incrementDp = new int[n];
        int[] decrementDp = new int[n];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            incrementDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && incrementDp[i] < incrementDp[j] + 1) {
                    incrementDp[i] = incrementDp[j] + 1;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            decrementDp[i] = 1;
            for (int j = n-1; j > i; j--) {
                if (arr[i] > arr[j] && decrementDp[i] < decrementDp[j] + 1) {
                    decrementDp[i] = decrementDp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, (incrementDp[i] + decrementDp[i] - 1));
        }

        System.out.println(max);
    }
}