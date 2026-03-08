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

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int[] grows = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            grows[i] = Integer.parseInt(st.nextToken());
        }

        int[][] sortedTrees = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedTrees[i][0] = trees[i];
            sortedTrees[i][1] = grows[i];
        }

        Arrays.sort(sortedTrees, (i, j) -> {
            if (i[1] == j[1]) {
                return Integer.compare(i[0], i[1]);
            }

            return Integer.compare(i[1], j[1]);
        });

        long answer = 0;
        for (int i = 0; i < n; i++) {
            long grow = (long) sortedTrees[i][1] * i;
            answer += (sortedTrees[i][0] + grow);
        }

        System.out.println(answer);
    }

}