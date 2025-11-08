import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] requests = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        long totalRequest = 0;
        int maxRequest = 0;

        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            totalRequest += requests[i];
            if (requests[i] > maxRequest) {
                maxRequest = requests[i];
            }
        }

        int M = Integer.parseInt(br.readLine());

        if (totalRequest <= M) {
            System.out.println(maxRequest);
            return;
        }

        int low = 0;
        int high = maxRequest;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long currentSum = 0;

            for (int req : requests) {
                if (req > mid) {
                    currentSum += mid;
                } else {
                    currentSum += req;
                }
            }

            if (currentSum <= M) {
                result = mid; 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}