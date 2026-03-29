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

    static int n, m;
    static boolean[] isRequired = new boolean[10];
    static int[] currentPassword;
    static int answer;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                isRequired[Integer.parseInt(st.nextToken())] = true;
            }
        }

        currentPassword = new int[n];
        generatePassword(0);
        System.out.println(answer);
    }

    static void generatePassword(int depth) {
        if (depth == n) {
            if (isValid()) {
                answer++;
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            currentPassword[depth] = i;
            generatePassword(depth + 1);
        }
    }

    static boolean isValid() {
        for (int i = 0; i <= 9; i++) {
            if (isRequired[i]) {
                boolean found = false;
                for (int j = 0; j < n; j++) {
                    if (currentPassword[j] == i) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    return false;
                }
            }
        }

        return true;
    }

}