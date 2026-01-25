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

    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static long min;
    static boolean[] visited = new boolean[3];
    static int[][] teleports = new int[3][4];

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        min = findDistance(startX, startY, endX, endY);

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                teleports[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMinDistance(startX, startY, 0);
        System.out.println(min);
    }

    static void findMinDistance(int nowX, int nowY, long distance) {
        min = Math.min(min, distance + findDistance(nowX, nowY, endX, endY));

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int sx = teleports[i][0];
                int sy = teleports[i][1];
                int ex = teleports[i][2];
                int ey = teleports[i][3];

                findMinDistance(ex, ey, distance + 10 + findDistance(nowX, nowY, sx, sy));
                findMinDistance(sx, sy, distance + 10 + findDistance(nowX, nowY, ex, ey));

                visited[i] = false;
            }
        }
    }

    static long findDistance(int sx, int sy, int ex, int ey) {
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }

}