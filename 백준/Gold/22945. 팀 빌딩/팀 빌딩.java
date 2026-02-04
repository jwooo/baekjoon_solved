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

        int[] stats = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stats[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        long max = 0;
        while (left < right) {
            long now = (long) (right - left - 1) * Math.min(stats[left], stats[right]);
            max = Math.max(max, now);

            if (stats[left] < stats[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(max);
    }
}