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

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long totalSupervisors = 0;

        for (int i = 0; i < n; i++) {
            totalSupervisors++;
            int remainingStudents = a[i] - b;

            if (remainingStudents > 0) {
                totalSupervisors += (long) remainingStudents / c;

                if (remainingStudents % c != 0) {
                    totalSupervisors++;
                }
            }
        }

        System.out.println(totalSupervisors);
    }
}