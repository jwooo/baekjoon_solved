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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] powerKey = new String[n];
        int[] powerValue = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            powerKey[i] = st.nextToken();
            powerValue[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int findNumber = Integer.parseInt(br.readLine());
            int start = 0;
            int end = powerValue.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (findNumber <= powerValue[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            sb.append(powerKey[start]).append("\n");
        }

        System.out.println(sb);
    }

}