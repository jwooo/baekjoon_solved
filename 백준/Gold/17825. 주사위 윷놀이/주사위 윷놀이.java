import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] dice = new int[10];
    static int[] pieces = new int[4];

    static int[] score = new int[33];
    static int[] next = new int[33];
    static int[] blue = new int[33];

    static int maxScore = 0;
    static final int END_NODE = 21;

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        initBoard();
        dfs(0, 0);
        System.out.println(maxScore);
    }

    static void dfs(int depth, int currentScore) {
        if (depth == 10) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        int roll = dice[depth];

        for (int i = 0; i < 4; i++) {
            int startPos = pieces[i];

            if (startPos == END_NODE) {
                continue;
            }

            int nextPos = startPos;
            if (blue[startPos] > 0) {
                nextPos = blue[startPos];
                for (int j = 1; j < roll; j++) {
                    nextPos = next[nextPos];
                }
            } else {
                for (int j = 0; j < roll; j++) {
                    nextPos = next[nextPos];
                }
            }

            boolean isOccupied = false;
            if (nextPos != END_NODE) {
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (pieces[j] == nextPos) {
                        isOccupied = true;
                        break;
                    }
                }
            }

            if (isOccupied) {
                continue;
            }

            pieces[i] = nextPos;
            dfs(depth + 1, currentScore + score[nextPos]);
            pieces[i] = startPos;
        }
    }

    static void initBoard() {
        for (int i = 1; i <= 20; i++) {
            score[i] = i * 2;
        }
        score[22] = 13;
        score[23] = 16;
        score[24] = 19;
        score[25] = 22;
        score[26] = 24;
        score[27] = 28;
        score[28] = 27;
        score[29] = 26;
        score[30] = 25;
        score[31] = 30;
        score[32] = 35;

        for (int i = 0; i < 20; i++) {
            next[i] = i + 1;
        }
        next[20] = END_NODE;
        next[END_NODE] = END_NODE;

        next[22] = 23;
        next[23] = 24;
        next[24] = 30;
        next[25] = 26;
        next[26] = 30;
        next[27] = 28;
        next[28] = 29;
        next[29] = 30;
        next[30] = 31;
        next[31] = 32;
        next[32] = 20;

        blue[5] = 22;
        blue[10] = 25;
        blue[15] = 27;
    }
}