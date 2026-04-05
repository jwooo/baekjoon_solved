import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder(br.readLine());
        List<String> prefix = new ArrayList<>();

        while (sb.length() > 0) {
            prefix.add(sb.toString());
            sb.deleteCharAt(0);
        }

        Collections.sort(prefix);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < prefix.size(); i++) {
            result.append(prefix.get(i)).append("\n");
        }

        System.out.println(result.toString().trim());
    }

}