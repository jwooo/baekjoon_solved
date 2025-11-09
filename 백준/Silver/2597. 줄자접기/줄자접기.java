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

    static double[][] dots;
    static double paperWidth;

    public void solution() throws IOException {
        paperWidth = Double.parseDouble(br.readLine());
        dots = new double[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Double.parseDouble(st.nextToken());
            dots[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < dots.length; i++) {
            if (dots[i][0] == dots[i][1]) {
                continue;
            }

            double mid = (dots[i][0] + dots[i][1]) / 2.0;
            double offset = Math.min(0.0, mid * 2 - paperWidth);

            for (int j = 0; j < dots.length; j++) {
                dots[j][0] = fold(dots[j][0], mid) - offset;
                dots[j][1] = fold(dots[j][1], mid) - offset;
            }

            paperWidth = Math.max(paperWidth - mid, mid - offset);
        }

        System.out.printf("%.1f", paperWidth);
    }

    private static double fold(double coordinate, double foldLine) {
        return (coordinate < foldLine) ? coordinate : 2 * foldLine - coordinate;
    }

}