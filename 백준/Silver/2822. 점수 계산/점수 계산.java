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
        List<Point> points = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            points.add(new Point(i, Integer.parseInt(br.readLine())));
        }

        Collections.sort(points);

        int sum = 0;
        List<Integer> indexes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Point now = points.get(i);
            sum += now.value;
            indexes.add(now.index);
        }

        Collections.sort(indexes);
        indexes.forEach(i -> sb.append(i).append(" "));

        System.out.println(sum);
        System.out.println(sb.toString().trim());
    }

    static class Point implements Comparable<Point> {
        int index;
        int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Point o) {
            return o.value - this.value;
        }
    }

}
