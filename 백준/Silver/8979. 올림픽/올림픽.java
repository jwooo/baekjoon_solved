import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int country = Integer.parseInt(st.nextToken());

        int[][] results = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int nowCountry = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            results[i][0] = nowCountry;
            results[i][1] = gold;
            results[i][2] = silver;
            results[i][3] = bronze;
        }

        Arrays.sort(results, (i, j) -> {
            if (i[1] != j[1]) {
                return j[1] - i[1];
            }

            if (i[2] != j[2]) {
                return j[2] - i[2];
            }

            return j[3] - i[3];
        });

        int targetIndex = 0;
        for (int i = 0; i < n; i++) {
            if (results[i][0] == country) {
                targetIndex = i;
                break;
            }
        }

        int rank = targetIndex;
        while (rank > 0
                && results[rank - 1][1] == results[targetIndex][1]
                && results[rank - 1][2] == results[targetIndex][2]
                && results[rank - 1][3] == results[targetIndex][3]
        ) {
            rank--;
        }

        System.out.println(rank + 1);
    }

}