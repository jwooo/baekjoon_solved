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
        st = new StringTokenizer(br.readLine());
        int[] trucks = new int[3];

        for (int i = 0; i < 3; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                visited[j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i < visited.length; i++) {
            int now = visited[i];
            if (now == 0) {
                continue;
            }

            answer += trucks[now - 1] * now;
        }

        System.out.println(answer);
    }
}
