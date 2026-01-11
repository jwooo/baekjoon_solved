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

        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int oddCount = 0;
        int maxLength = 0;

        for (int end = 0; end < n; end++) {
            if (s[end] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (s[start] % 2 != 0) {
                    oddCount--;
                }

                start++;
            }

            int nowLength = (end - start + 1) - oddCount;
            maxLength = Math.max(maxLength, nowLength);
        }

        System.out.println(maxLength);
    }

}
