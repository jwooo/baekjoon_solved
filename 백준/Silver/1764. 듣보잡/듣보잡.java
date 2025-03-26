import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> unHeard = new HashSet<>();
        List<String> unHeardAndSaw = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            String human = br.readLine();
            if (i < n) {
                unHeard.add(human);
            } else {
                if (unHeard.contains(human)) {
                    unHeardAndSaw.add(human);
                }
            }
        }

        Collections.sort(unHeardAndSaw);
        System.out.println(unHeardAndSaw.size());
        for (int i = 0; i < unHeardAndSaw.size(); i++) {
            System.out.println(unHeardAndSaw.get(i));
        }
    }

}