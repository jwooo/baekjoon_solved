import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] arr;

    public static void main(String[] args) {
       input();
       calculate();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new boolean[n+1][n+1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = true;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate() {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (arr[i][j] || arr[j][k] || arr[k][i]) continue;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
