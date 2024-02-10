import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value % 2 == 0;
        }

        int length = 0;
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;

        while (endIndex < n) {
            if (count < k) {
                if (!arr[endIndex]) count++;
                endIndex++;
                length = Math.max(endIndex - startIndex - count, length);
            } else if (arr[endIndex]) {
                endIndex++;
                length = Math.max(endIndex - startIndex - count, length);
            } else {
                if (!arr[startIndex]) count--;
                startIndex++;
            }
        }

        System.out.println(length);
    }
}