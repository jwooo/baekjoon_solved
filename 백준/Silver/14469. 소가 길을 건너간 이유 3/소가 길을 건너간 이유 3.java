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

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (i, j) -> {
            if (i[0] == j[0]) {
                return i[1] - j[1];
            }

            return i[0] - j[0];
        });

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time < arr[i][0]) {
                time = arr[i][0];
            }

            time += arr[i][1];
        }

        System.out.println(time);
    }
}