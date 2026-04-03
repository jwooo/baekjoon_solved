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
        StringBuilder result = new StringBuilder();

        while (true) {
            String line = br.readLine();

            if (line.equals("END")) {
                break;
            }

            StringBuilder reverse = new StringBuilder(line).reverse();
            result.append(reverse).append("\n");
        }

        System.out.println(result);
    }

}