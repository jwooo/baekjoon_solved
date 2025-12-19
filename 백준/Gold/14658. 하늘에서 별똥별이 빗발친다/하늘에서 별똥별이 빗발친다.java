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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] meteors = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            meteors[i][0] = x;
            meteors[i][1] = y;
        }

        int answer = 0;
        for (int[] meteor1 : meteors) {
            for (int[] meteor2 : meteors) {
                int cornerX = meteor1[0];
                int cornerY = meteor2[1];

                int nowStars = 0;
                for (int[] targetMeteor : meteors) {
                    if (targetMeteor[0] >= cornerX && targetMeteor[0] <= cornerX + l &&
                            targetMeteor[1] >= cornerY && targetMeteor[1] <= cornerY + l) {
                        nowStars++;
                    }
                }

                answer = Math.max(answer, nowStars);
            }
        }

        System.out.println(k - answer);
    }
}
