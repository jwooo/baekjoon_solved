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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        while (left <= right && right < n) {
            if (right <= n-1 && count[arr[right]] < k) {
                count[arr[right]]++;
                right++;
            } else if (count[arr[right]] == k) {
                count[arr[left]]--;
                left++;
            }

            ans = Math.max(ans, right - left);
        }

        System.out.println(ans);
    }
}