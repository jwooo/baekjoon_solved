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

    static int n;
    static int k;
    static int count;
    static int answer;
    static int[] belt;
    static boolean[] robots;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n * 2];
        robots = new boolean[n * 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (countZero() < k) {
            rotateConveyor();
            moveRobots();

            if (belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
            }

            answer++;
        }

        System.out.println(answer);
    }

    private void rotateConveyor() {
        int lastBelt = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = lastBelt;

        for (int i = n - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }

        robots[0] = false;
        robots[n - 1] = false;
    }

    private void moveRobots() {
        for (int i = n - 1; i > 0; i--) {
            if (robots[i - 1] && !robots[i] && belt[i] > 0) {
                robots[i] = true;
                robots[i - 1] = false;
                belt[i]--;
            }
        }

        robots[n - 1] = false;
    }

    private int countZero() {
        int count = 0;

        for (int now : belt) {
            if (now == 0) {
                count++;
            }
        }

        return count;
    }
}
