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

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pairs.add(new Pair(x, y));
        }

        Collections.sort(pairs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pairs.size(); i++) {
            Pair now = pairs.get(i);
            sb.append(now.x).append(" ").append(now.y).append("\n");
        }

        System.out.println(sb);
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair o) {
            if (y != o.y) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return "Pair{x=" + x + ",y=" + y + "}";
        }
    }
}
