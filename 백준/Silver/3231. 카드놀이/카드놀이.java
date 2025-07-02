import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(br.readLine()), i);
        }

        int answer = 0;
        int now = 1;
        while (now < n) {
            int nowIndex = map.get(now);
            int nextIndex = map.get(++now);

            if (nowIndex > nextIndex) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
