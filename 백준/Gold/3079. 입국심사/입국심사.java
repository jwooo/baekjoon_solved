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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 심사대 수
        int m = Integer.parseInt(st.nextToken()); // 인원 수

        long[] times = new long[n];

        long maxTime = 0;

        for (int i = 0; i < n; i++) {
            times[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        Arrays.sort(times);

        long start = 0;
        long end = maxTime * m;

        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int i = 0; i < n; i++) {
                count += mid / times[i];
                if (count > m) break;
            }

            if (m <= count) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }

}