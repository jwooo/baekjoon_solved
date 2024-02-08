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
        int k = Integer.parseInt(st.nextToken()) * 2 + 1;

        int[] ice = new int[1_000_0001];
        int g, x;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            g = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            ice[x] = g;
        }

        int sum = 0, max = 0;
        for (int i = 0; i <= 1_000_000; i++) {
            if (i - k >= 0) sum -= ice[i - k];
            sum += ice[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}