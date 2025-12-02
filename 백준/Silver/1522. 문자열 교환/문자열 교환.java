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

    public void solution() throws IOException {
        char[] arr = br.readLine().toCharArray();

        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                a++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int b = 0;
            for (int j = i; j < i + a; j++) {
                if (arr[j % arr.length] == 'b') {
                    b++;
                }
            }

            min = Math.min(min, b);
        }

        System.out.println(min);
    }

}