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

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> stones = new ArrayList<>();
        stones.add(0);
        stones.add(d);

        for (int i = 0; i < n; i++) {
            stones.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(stones);

        long low = 0;
        long high = d;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(mid, m, stones)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(long minDistance, int m, List<Integer> stones) {
        int removeCount = 0;
        int lastPosIndex = 0;

        for (int i = 1; i < stones.size(); i++) {
            if (stones.get(i) - stones.get(lastPosIndex) < minDistance) {
                removeCount++;
            } else {
                lastPosIndex = i;
            }
        }

        return removeCount <= m;
    }

}