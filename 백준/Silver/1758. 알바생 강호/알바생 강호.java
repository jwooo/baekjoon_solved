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
        int n = Integer.parseInt(br.readLine());

        List<Long> tips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tips.add(Long.parseLong(br.readLine()));
        }

        tips.sort(Collections.reverseOrder());
        long answer = 0;
        for (int i = 0; i < tips.size(); i++) {
            Long now = tips.get(i);
            if (now - i >= 0) {
                answer += now - i;
            }
        }

        System.out.println(answer);
    }


}