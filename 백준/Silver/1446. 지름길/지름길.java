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

    private static final int MAX_VALUE = 100_000_000;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        int[][] shortcut = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            shortcut[i] = new int[]{start, end, dist};
        }

        int[] distances = new int[distance + 1];
        Arrays.fill(distances, MAX_VALUE);
        distances[0] = 0;

        for (int i = 0; i <= distance; i++) {
            if (i != 0) {
                distances[i] = Math.min(distances[i], distances[i - 1] + 1);
            }

            for (int[] sc : shortcut) {
                int start = sc[0];
                int end = sc[1];
                int dist = sc[2];

                if (start != i) {
                    continue;
                }
                if (end > distance) {
                    continue;
                }

                distances[end] = Math.min(distances[end], distances[start] + dist);
            }
        }

        System.out.println(distances[distance]);
    }


}
