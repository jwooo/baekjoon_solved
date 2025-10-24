import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static int m;
    static int[] gems;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gems = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, gems[i]);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;

            int jealously = getJealously(mid);
            if (jealously <= n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }

    private int getJealously(int now) {
        int answer = 0;

        for (int i = 0; i < m; i++) {
            answer += gems[i] / now;
            if (gems[i] % now != 0) {
                answer++;
            }
        }

        return answer;
    }

}