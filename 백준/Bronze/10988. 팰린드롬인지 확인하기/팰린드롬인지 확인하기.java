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
        char[] arr = br.readLine().toCharArray();

        int start = 0;
        int end = arr.length - 1;
        int answer = 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                answer = 0;
                break;
            }

            start++;
            end--;
        }

        System.out.println(answer);
    }
}
