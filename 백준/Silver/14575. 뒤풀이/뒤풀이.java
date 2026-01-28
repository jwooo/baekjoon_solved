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
        int t = Integer.parseInt(st.nextToken());

        int[] l = new int[n];
        int[] r = new int[n];

        long minSumTotal = 0;
        long maxSumTotal = 0;
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            minSumTotal += l[i];
            maxSumTotal += r[i];

            if (l[i] > maxL) {
                maxL = l[i];
            }
        }

        if (t < minSumTotal || t > maxSumTotal) {
            System.out.println(-1);
            return;
        }

        int low = maxL;
        int high = t;
        int answer = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            long nowMaxSum = 0;
            for (int i = 0; i < n; i++) {
                nowMaxSum += Math.min(mid, r[i]);
            }

            if (t <= nowMaxSum) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }


}