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
        int l = Integer.parseInt(st.nextToken());

        int[][] paddles = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            paddles[i][0] = Integer.parseInt(st.nextToken());
            paddles[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(paddles, (i, j) -> {
            if (i[0] == j[0]) {
                return Integer.compare(i[1], j[1]);
            }

            return Integer.compare(i[0], j[0]);
        });

        int plankCount = 0;
        int lastPlankEnd = 0;

        for (int[] paddle : paddles) {
            int start = paddle[0];
            int end = paddle[1];

            int currentPos = Math.max(start, lastPlankEnd);

            if (currentPos >= end) {
                continue;
            }

            int lengthToCover = end - currentPos;
            int numPlankNeeded = (int) Math.ceil((double) lengthToCover / l);

            plankCount += numPlankNeeded;
            lastPlankEnd = currentPos + numPlankNeeded * l;
        }

        System.out.println(plankCount);
    }
}