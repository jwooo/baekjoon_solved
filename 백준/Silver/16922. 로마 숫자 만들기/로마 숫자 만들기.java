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

    static int n;
    static int[] num = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        dfs(0, 0, 0);
        System.out.println(set.size());
    }

    private void dfs(int depth, int sum, int idx) {
        if (depth == n) {
            set.add(sum);
            return;
        }

        for (int i = idx; i < 4; i++) {
            dfs(depth + 1, sum + num[i], i);
        }
    }

}
