import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String event = st.nextToken();

            if (event.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (event.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            } else if (event.equals("check")) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (event.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (event.equals("all")) {
                set.clear();

                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }

        System.out.println(sb);
    }

}