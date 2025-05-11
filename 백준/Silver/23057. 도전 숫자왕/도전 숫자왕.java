import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        long m = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            m += a[i];
        }

        Set<Long> sums = new HashSet<>();
        dfs(0, 0L, a, sums);

        System.out.println(m - sums.size());
    }

    static void dfs(int index, long now, int[] a, Set<Long> sums) {
        if (index == a.length) {
            return;
        }

        long with = now + a[index];
        sums.add(with);

        dfs(index + 1, with, a, sums);
        dfs(index + 1, now, a, sums);
    }


}
