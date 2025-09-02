import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temps = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }

        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += temps[i];
        }

        int maxSum = windowSum;
        for (int i = K; i < N; i++) {
            windowSum = windowSum - temps[i - K] + temps[i];
            
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        System.out.println(maxSum);
    }
}