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

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = 1 + (m - 1);
        int answer = 0;

        for (int apple : arr) {
            if (apple < start) {
                int move = start - apple;
                answer += move;
                start -= move;
                end -= move;
            } else if (apple > end) {
                int move = apple - end;
                answer += move;
                start += move;
                end += move;
            }
        }

        System.out.println(answer);
    }
}
