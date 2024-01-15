

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

    static long[][] arr = new long[1001][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    arr[i][j] += arr[i-1][k] % 10007;
                }
            }
        }

        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            sum += arr[n][i] % 10007;
        }

        System.out.println(sum % 10007);
    }

}