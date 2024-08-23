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
        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            int input3 = Integer.parseInt(st.nextToken());

            for (int j = input1 - 1; j < input2; j++) {
                arr[j] = input3;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}