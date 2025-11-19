import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n != 0) {
            st = new StringTokenizer(br.readLine());
        }

        List<int[]> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(new int[]{Integer.parseInt(st.nextToken()), 0});
        }

        scores.add(new int[]{score, 1});
        scores.sort((i, j) -> {
            if (i[0] == j[0]) {
                return i[1] - j[1];
            }

            return j[0] - i[0];
        });

        int index = -1;
        for (int i = 0; i < Math.min(p, scores.size()); i++) {
            if (scores.get(i)[0] == score && scores.get(i)[1] == 1) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = 0; i < Math.min(p, scores.size()); i++) {
                if (scores.get(i)[0] == score) {
                    index = i;
                    break;
                }
            }

            System.out.println(index + 1);
        } else {
            System.out.println(-1);
        }
    }

}