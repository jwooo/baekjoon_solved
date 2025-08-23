import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String goal = br.readLine();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] target = new int[n];

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            arr1[i] = arr2[i] = start.charAt(i) - '0';
            target[i] = goal.charAt(i) - '0';
        }

        arr1[0] = 1 - arr1[0];
        arr1[1] = 1 - arr1[1];
        count1++;

        for (int i = 1; i < n; i++) {
            if (isDifferent(i, arr1, target)) {
                arr1[i - 1] = 1 - arr1[i - 1];
                arr1[i] = 1 - arr1[i];

                if (i + 1 < n) {
                    arr1[i + 1] = 1 - arr1[i + 1];
                }

                count1++;
            }

            if (isDifferent(i, arr2, target)) {
                arr2[i - 1] = 1 - arr2[i - 1];
                arr2[i] = 1 - arr2[i];
                if (i + 1 < n) {
                    arr2[i + 1] = 1 - arr2[i + 1];
                }
                count2++;
            }
        }

        if (arr1[n - 1] != target[n - 1]) {
            count1 = Integer.MAX_VALUE;
        }
        if (arr2[n - 1] != target[n - 1]) {
            count2 = Integer.MAX_VALUE;
        }

        if (count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(count1, count2));
        }
    }

    private boolean isDifferent(int index, int[] arr, int[] target) {
        return arr[index - 1] != target[index - 1];
    }
}
