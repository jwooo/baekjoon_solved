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
    static int m;
    static int[][] musics;
    static int maxMusicCount = -1;
    static int minNeedGuitars = Integer.MAX_VALUE;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        musics = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String possibleMusics = st.nextToken();

            for (int k = 0; k < possibleMusics.length(); k++) {
                musics[i][k] = possibleMusics.charAt(k) == 'Y' ? 1 : 0;
            }
        }

        dfs(0, 0, new int[m]);

        if (maxMusicCount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minNeedGuitars);
        }
    }

    private void dfs(int depth, int guitars, int[] playlist) {
        int nowPlaylistCount = 0;
        for (int j : playlist) {
            if (j > 0) {
                nowPlaylistCount++;
            }
        }

        if (nowPlaylistCount > maxMusicCount) {
            maxMusicCount = nowPlaylistCount;
            minNeedGuitars = guitars;
        } else if (nowPlaylistCount == maxMusicCount) {
            minNeedGuitars = Math.min(minNeedGuitars, guitars);
        }

        if (depth == n) {
            return;
        }

        dfs(depth + 1, guitars, playlist);

        for (int i = 0; i < playlist.length; i++) {
            if (musics[depth][i] > 0) {
                playlist[i]++;
            }
        }

        dfs(depth + 1, guitars + 1, playlist);

        for (int i = 0; i < playlist.length; i++) {
            if (musics[depth][i] > 0) {
                playlist[i]--;
            }
        }
    }


}