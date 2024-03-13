import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int shuffle = Integer.parseInt(st.nextToken());

        int[] D = new int[n + 1];
        int[] P = new int[n + 1];

        // init P
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // init D
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        while (shuffle-- > 0) {
            int[] shuffleCards = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                shuffleCards[D[i]] = P[i];
            }

            P = shuffleCards;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(P[i] + " ");
        }

        System.out.println(sb.toString());
    }
}