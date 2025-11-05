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
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (i, j) -> {
            if (i[0] == j[0]) {
                return i[1] - j[1];
            }

            return i[0] - j[0];
        });

        long lineLength = getLineLength(arr, n);

        System.out.println(lineLength);
    }

    private static long getLineLength(int[][] arr, int n) {
        long start = arr[0][0];
        long end = arr[0][1];
        long lineLength = end - start;

        for (int i = 1; i < n; i++) {
            long lineStart = arr[i][0];
            long lineEnd = arr[i][1];

            if (end > lineStart) {
                long length = lineEnd - end;

                if (length > 0) {
                    lineLength += length;
                    end = lineEnd;
                }
            } else {
                start = lineStart;
                end = lineEnd;
                lineLength += lineEnd - lineStart;
            }
        }
        return lineLength;
    }

}