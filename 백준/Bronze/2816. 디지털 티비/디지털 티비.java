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
        int n = Integer.parseInt(br.readLine());

        String[] channels = new String[n];
        for (int i = 0; i < n; i++) {
            channels[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (!channels[index].equals("KBS1")) {
            index++;
            result.append("1");
        }

        while (index > 0) {
            String temp = channels[index];
            channels[index] = channels[index - 1];
            channels[index - 1] = temp;

            index--;
            result.append("4");
        }

        while (!channels[index].equals("KBS2")) {
            index++;
            result.append("1");
        }

        while (index > 1) {
            index--;
            result.append("4");
        }

        System.out.println(result);
    }

}