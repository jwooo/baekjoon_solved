import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int startIndexA = 0;
        int startIndexB = 0;

        while (startIndexA < n && startIndexB < m) {
            if (a[startIndexA] < b[startIndexB]) {
                sb.append(a[startIndexA++] + " ");
            } else {
                sb.append(b[startIndexB++] + " ");
            }
        }

        if (startIndexA == n) {
            for (int i = startIndexB; i < m; i++) {
                sb.append(b[i] + " ");
            }
        }
        if (startIndexB == m) {
            for (int i = startIndexA; i < n; i++) {
                sb.append(a[i] + " ");
            }
        }

        System.out.println(sb);
    }
}