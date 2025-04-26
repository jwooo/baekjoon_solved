import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int answer = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Set<Character> alphabet = new HashSet<>();
        alphabet.add(map[0][0]);

        dfs(0, 0, 1, map, alphabet);
        System.out.println(answer);
    }

    public void dfs(int x, int y, int count, char[][] map, Set<Character> alphabet) {
        answer = Math.max(answer, count);

        int sizeOfY = map.length;
        int sizeOfX = map[0].length;

        for (int i = 0; i < 4; i++) {
            int nowY = y + dy[i];
            int nowX = x + dx[i];

            if (nowY < 0 || nowY >= sizeOfY || nowX < 0 || nowX >= sizeOfX) {
                continue;
            }
            if (!alphabet.contains(map[nowY][nowX])) {
                alphabet.add(map[nowY][nowX]);
                dfs(nowX, nowY, count + 1, map, alphabet);
                alphabet.remove(map[nowY][nowX]);
            }
        }
    }
}