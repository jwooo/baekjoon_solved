import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int low = 1;
        int high = houses[n - 1] - houses[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canInstall(houses, c, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private boolean canInstall(int[] houses, int c, int distance) {
        int count = 1;
        int lastInstalledPos = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalledPos >= distance) {
                count++;
                lastInstalledPos = houses[i];
            }
        }

        return count >= c;
    }
}
