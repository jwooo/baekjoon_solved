import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        char leftStartKey = st.nextToken().charAt(0);
        char rightStartKey = st.nextToken().charAt(0);

        String word = br.readLine();

        int second = 0;
        int nowLeftHandX = 0;
        int nowLeftHandY = 0;
        int nowRightHandX = 0;
        int nowRightHandY = 0;

        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j] == leftStartKey) {
                    nowLeftHandX = j;
                    nowLeftHandY = i;
                } else if (keyboard[i][j] == rightStartKey) {
                    nowRightHandX = j;
                    nowRightHandY = i;
                }
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char clickWord = word.charAt(i);
            int clickWordX = 0;
            int clickWordY = 0;

            for (int j = 0; j < keyboard.length; j++) {
                for (int k = 0; k < keyboard[j].length; k++) {
                    if (keyboard[j][k] == clickWord) {
                        clickWordY = j;
                        clickWordX = k;
                    }
                }
            }

            if (nowLeftHandX == clickWordX && nowLeftHandY == clickWordY) {
                second++;
                continue;
            } else if (nowRightHandX == clickWordX && nowRightHandY == clickWordY) {
                second++;
                continue;
            } else {
                if (clickWordY < 2) {
                    if (clickWordX < 5) {
                        second += Math.abs(nowLeftHandX - clickWordX) + Math.abs(nowLeftHandY - clickWordY) + 1;
                        nowLeftHandX = clickWordX;
                        nowLeftHandY = clickWordY;
                    } else {
                        second += Math.abs(nowRightHandX - clickWordX) + Math.abs(nowRightHandY - clickWordY)  + 1;
                        nowRightHandX = clickWordX;
                        nowRightHandY = clickWordY;
                    }
                } else {
                    if (clickWordX < 4) {
                       second += Math.abs(nowLeftHandX - clickWordX) + Math.abs(nowLeftHandY - clickWordY) + 1;
                       nowLeftHandX = clickWordX;
                       nowLeftHandY = clickWordY;
                    } else {
                        second += Math.abs(nowRightHandX - clickWordX) + Math.abs(nowRightHandY - clickWordY)  + 1;
                        nowRightHandX = clickWordX;
                        nowRightHandY = clickWordY;
                    }
                }
            }
        }

        System.out.println(second);
    }
}