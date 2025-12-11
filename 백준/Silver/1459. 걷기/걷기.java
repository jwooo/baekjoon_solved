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

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long result = 0;

        long cost1 = (x + y) * w;
        long cost2 = Math.min(x, y) * s + Math.abs(x - y) * w;

        long cost3;
        if ((x + y) % 2 == 0) {
            cost3 = Math.max(x, y) * s;
        } else {
            cost3 = (Math.max(x, y) - 1) * s + w;
        }

        result = Math.min(cost1, Math.min(cost2, cost3));
        System.out.println(result);
    }
}
