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
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[2][n + 1];
        boolean[] isWatchCow = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int cowValue = Integer.parseInt(st.nextToken());
            int cowMove = Integer.parseInt(st.nextToken());

            if (!isWatchCow[cowValue]) {
                isWatchCow[cowValue] = true;

                arr[0][cowValue] = cowMove;
            } else {
                if (cowMove != arr[0][cowValue]) {
                    arr[0][cowValue] = cowMove;
                    arr[1][cowValue]++;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[1][i] > 0) sum += arr[1][i];
        }

        System.out.println(sum);
    }
}
