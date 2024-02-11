import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        int[] checked = new int[d+1];

        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int res = 1;
        checked[c]++;
        for (int i = 0; i < k; i++) {
            if (checked[belt[i]] == 0) res++;
            checked[belt[i]]++;
        }

        int eatSushi = res;

        for (int i = 1; i < n; i++) {
            int prevSushi = belt[i-1];

            checked[prevSushi]--;
            if (checked[prevSushi] == 0) eatSushi--;

            int nextSushi = belt[(i+k-1) % n];
            if (checked[nextSushi] == 0) eatSushi++;
            checked[nextSushi]++;

            res = Math.max(res, eatSushi);
        }

        System.out.println(res);
    }
}