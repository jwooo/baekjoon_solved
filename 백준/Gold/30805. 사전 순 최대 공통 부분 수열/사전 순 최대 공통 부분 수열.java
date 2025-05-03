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
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int indexA = 1;
        int indexB = 1;
        StringBuilder answer = new StringBuilder();

        while (indexA <= n && indexB <= m) {
            int best = 0;

            for (int i = indexA; i <= n; i++) {
                for (int j = indexB; j <= m; j++) {
                    if (a[i] == b[j] && a[i] > best) {
                        best = a[i];
                    }
                }
            }

            if (best == 0) {
                break;
            }

            answer.append(best).append(' ');
            count++;

            while (a[indexA] != best) {
                indexA++;
            }
            while (b[indexB] != best) {
                indexB++;
            }

            indexA++;
            indexB++;
        }

        System.out.println(count);
        System.out.println(answer);
    }

}