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

    private static final int MAX = 10000001;

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> points = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            points.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            points.get(color).add(point);
        }

        for (int i = 0; i <= n; i++) {
            if (!points.get(i).isEmpty()) {
                Collections.sort(points.get(i));
            }
        }

        int answer = 0;
        for (int i = 0; i <= n; i++) {
            List<Integer> colorPoints = points.get(i);

            if (colorPoints.isEmpty() || colorPoints.size() == 1) {
                continue;
            }

            for (int j = 0; j < colorPoints.size(); j++) {
                int left = j != 0 ? colorPoints.get(j - 1) : MAX;
                int right = j != colorPoints.size() - 1 ? colorPoints.get(j + 1) : MAX;

                int leftDistance = Math.abs(colorPoints.get(j) - left);
                int rightDistance = Math.abs(colorPoints.get(j) - right);

                if (leftDistance < rightDistance) {
                    answer += leftDistance;
                } else {
                    answer += rightDistance;
                }
            }
        }

        System.out.println(answer);
    }

}