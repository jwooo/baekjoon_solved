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
        boolean[] visited = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            visited[n] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!visited[i]) System.out.println(i);
        }
    }
}

