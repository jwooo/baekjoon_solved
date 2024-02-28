import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int min = arr[0];
            int max = arr[0];

            for (int j = 1; j < n; j++) {
                int now = arr[j];

                if (now > max) {
                    max = now;
                    continue;
                }
                if (now < min) {
                    min = now;
                    continue;
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
