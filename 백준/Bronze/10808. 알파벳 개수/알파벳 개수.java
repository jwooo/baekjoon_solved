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
        int[] count = new int[26];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            count[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
