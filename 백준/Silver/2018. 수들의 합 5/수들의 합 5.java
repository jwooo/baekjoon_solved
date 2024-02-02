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
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;

        while (endIndex != n) {
            if (sum == n) {
                endIndex++;
                sum = sum + endIndex;
                count++;
            } else if (sum > n) { 
                sum = sum - startIndex;
                startIndex++;
            } else if (sum < n) {
                endIndex++;
                sum = sum + endIndex;
            }
        }

        System.out.println(count);
    }
}