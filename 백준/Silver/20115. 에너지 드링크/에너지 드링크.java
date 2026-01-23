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
        int n = Integer.parseInt(br.readLine());
        double[] drinks = new double[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drinks);
        for (int i = 0; i < n - 1; i++) {
            drinks[n - 1] += drinks[i] / 2;
        }

        System.out.println(drinks[n - 1]);
    }

}