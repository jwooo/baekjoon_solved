import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            int[] a = new int[n + 1];
            int[] parent = new int[n + 1];
            int targetIdx = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == k) {
                    targetIdx = i;
                }
            }

            parent[1] = 0;
            int p = 0;
            for (int i = 2; i <= n; i++) {
                if (a[i] != a[i - 1] + 1) {
                    p++;
                }
                parent[i] = p;
            }

            int count = 0;
            if (parent[targetIdx] != 0 && parent[parent[targetIdx]] != 0) {
                int pIdx = parent[targetIdx];
                int gpIdx = parent[pIdx];

                for (int i = 1; i <= n; i++) {
                    if (parent[parent[i]] == gpIdx && parent[i] != pIdx) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}