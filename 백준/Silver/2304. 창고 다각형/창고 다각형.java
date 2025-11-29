import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[1001];

        int maxLength = 0;
        int maxHeight = 0;
        int maxHeightIndex = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            heights[length] = height;

            if (length > maxLength) {
                maxLength = length;
            }

            if (height > maxHeight) {
                maxHeight = height;
                maxHeightIndex = length;
            }
        }

        int nowMaxHeight = 0;
        int totalArea = 0;
        for (int i = 0; i <= maxHeightIndex; i++) {
            nowMaxHeight = Math.max(nowMaxHeight, heights[i]);
            totalArea += nowMaxHeight;
        }

        nowMaxHeight = 0;
        for (int i = maxLength; i > maxHeightIndex; i--) {
            nowMaxHeight = Math.max(nowMaxHeight, heights[i]);
            totalArea += nowMaxHeight;
        }

        System.out.println(totalArea);
    }

}