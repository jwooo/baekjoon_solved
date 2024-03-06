import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (isMan(gender)) {
                for (int i = index; i <= n; i = i++ + index) {
                    arr[i] = arr[i] == 1 ? 0 : 1;
                }
            } else {
                int left = index - 1;
                int right = index + 1;

                int leftMaxLength = index;
                int rightMaxLength = index;

                while (left > 0 && right <= n) {
                    if (arr[left] == arr[right]) {
                        leftMaxLength = left;
                        rightMaxLength = right;
                    } else break;

                    left--;
                    right++;
                }

                for (int i = leftMaxLength; i <= rightMaxLength; i++) {
                    arr[i] = arr[i] == 1 ? 0 : 1;
                }
            }
        }

        int printIndex = n / 20;
        int nowIndex = 1;

        if (printIndex > 0) {
            for (int i = 0; i < printIndex; i++) {
                int temp = nowIndex;
                for (int j = temp; j < temp + 20; j++) {
                    System.out.print(arr[j] + " ");
                    nowIndex++;
                }
                System.out.println();
            }
        }

        for (int i = nowIndex; i < nowIndex + n % 20; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private boolean isMan(int gender) {
        return gender == 1;
    }
}