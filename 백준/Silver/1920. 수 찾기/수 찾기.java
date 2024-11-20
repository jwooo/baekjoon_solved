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

    void solution() throws IOException {
        // setUp
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] baseArr = new int[n];

        for (int i = 0; i < baseArr.length; i++) {
            baseArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(baseArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] findArr = new int[m];

        for (int i = 0; i < findArr.length; i++) {
            findArr[i] = Integer.parseInt(st.nextToken());
        }

        // find M
        for (int i = 0; i < findArr.length; i++) {
            int findNumber = findArr[i];
            int startIndex = 0;
            int endIndex = baseArr.length - 1;

            int result = 0;

            while (startIndex <= endIndex) {
                int middleIndex = (startIndex + endIndex) / 2;

                if (baseArr[middleIndex] > findNumber) {
                    endIndex = middleIndex - 1;
                } else if (baseArr[middleIndex] < findNumber) {
                    startIndex = middleIndex + 1;
                } else if (baseArr[middleIndex] == findNumber) {
                    result = 1;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}