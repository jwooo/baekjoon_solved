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

    void solution() throws IOException {
        // given
        int n = Integer.parseInt(br.readLine());
        int[] shirts = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int shirtsBundle = Integer.parseInt(st.nextToken());
        int pensBundle = Integer.parseInt(st.nextToken());

        // when
        int minShirtsOrderCount = 0;

        int pensMaxBundleOrderCount = n / pensBundle;
        int oncePenOrderCount = n % pensBundle;

        for (int i = 0; i < 6; i++) {
            int now = shirts[i];

            while (now > 0) {
                now = now - shirtsBundle;
                minShirtsOrderCount++;
            }
        }

        // then
        System.out.println(minShirtsOrderCount);
        System.out.println(pensMaxBundleOrderCount + " " + oncePenOrderCount);
    }

}