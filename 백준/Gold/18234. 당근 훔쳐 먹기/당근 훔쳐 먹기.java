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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<Carrot> carrots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            carrots.add(new Carrot(w, p));
        }

        Collections.sort(carrots);

        long total = 0;
        for (int i = 0; i < n; i++) {
            long day = t - n + i;
            Carrot carrot = carrots.get(i);

            total += carrot.w + carrot.p * day;
        }

        System.out.println(total);
    }

    static class Carrot implements Comparable<Carrot> {
        int w;
        int p;

        public Carrot(int w, int p) {
            this.w = w;
            this.p = p;
        }

        public int compareTo(Carrot o) {
            if (this.p == o.p) {
                return Integer.compare(this.w, o.w);
            }

            return Integer.compare(this.p, o.p);
        }
    }

}