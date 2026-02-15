import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (i, j) -> {
            int a = i % 10;
            int b = j % 10;
            
            if (a == b) {
                return Integer.compare(i, j);
            }
            
            if (a == 0) return -1;
            if (b == 0) return 1;
            
            return a - b;
        });

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 10) {
                continue;
            }
            if (m == 0) {
                break;
            }

            int cutting = arr[i] % 10 > 0 ? arr[i] / 10 : arr[i] / 10 - 1;

            if (m < cutting) {
                answer += m;
                m = 0;
            } else {
                answer += arr[i] / 10;
                m -= cutting;
            }
        }

        System.out.println(answer);
    }

}