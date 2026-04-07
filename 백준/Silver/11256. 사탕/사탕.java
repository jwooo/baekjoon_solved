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
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());

            int[] boxes = new int[box];
            for (int i = 0; i < box; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                boxes[i] = r * c;
            }

            Arrays.sort(boxes);

            int index = box - 1;
            int answer = 0;
            while (candy > 0) {
                candy -= boxes[index--];
                answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}