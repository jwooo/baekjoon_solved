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

    static int[] arr = new int[3];

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                System.out.println(sb.toString().trim());
                return;
            }

            if (!isScalene()) {
                sb.append("Invalid").append("\n");
                continue;
            }

            int count = getSameCount();

            if (count == 3) {
                sb.append("Equilateral");
            } else if (count == 2) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }

            sb.append("\n");
        }

    }

    private boolean isScalene() {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < 3; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        return sum - max > max;
    }

    private int getSameCount() {
        boolean[] visited = new boolean[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == arr[j]) {
                    visited[i] = visited[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (visited[i]) {
                count++;
            }
        }

        return count;
    }


}