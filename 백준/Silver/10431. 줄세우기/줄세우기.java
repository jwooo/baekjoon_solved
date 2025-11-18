import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int tc = Integer.parseInt(st.nextToken());
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer> line = new ArrayList<>();
            int totalSteps = 0;

            for (int height : heights) {
                int insertionPoint = -1;

                for (int k = 0; k < line.size(); k++) {
                    if (line.get(k) > height) {
                        insertionPoint = k;
                        break;
                    }
                }

                if (insertionPoint != -1) {
                    totalSteps += line.size() - insertionPoint;
                    line.add(insertionPoint, height);
                } else {
                    line.add(height);
                }
            }

            sb.append(tc).append(" ").append(totalSteps).append("\n");
        }

        System.out.println(sb.toString());
    }

}