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
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] lines = br.readLine().toCharArray();

        int bCount = 0;
        int wCount = 0;

        int start = 0;

        int answer = 0;

        for (int end = 0; end < n; end++) {
            if (lines[end] == 'W') {
                wCount++;
            } else {
                bCount++;
            }

            while (bCount > b) {
                if (lines[start] == 'W') {
                    wCount--;
                } else {
                    bCount--;
                }

                start++;
            }

            if (wCount >= w) {
                int now = end - start + 1;
                answer = Math.max(answer, now);
            }
        }

        System.out.println(answer);
    }

}