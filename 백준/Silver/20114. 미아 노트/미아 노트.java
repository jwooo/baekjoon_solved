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
    static int h;
    static int w;
    static char[][] arr;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new char[h][n * w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();

            for (int j = 0; j < n * w; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(findCharacter(i));
        }

        System.out.println(sb);
    }

    private char findCharacter(int sequence) {
        for (int i = 0; i < h; i++) {
            for (int j = sequence * w; j < sequence * w + w; j++) {
                if (arr[i][j] != '?') {
                    return arr[i][j];
                }
            }
        }

        return '?';
    }
}
