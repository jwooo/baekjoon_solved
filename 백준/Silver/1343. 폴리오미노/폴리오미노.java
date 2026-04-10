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

    static String[] polyominos = {"AAAA", "BB"};

    public void solution() throws IOException {
        char[] boards = br.readLine().toCharArray();

        int countX = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < boards.length; i++) {
            if (boards[i] == 'X') {
                countX++;
            } else {
                if (countX % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                if (countX > 2) {
                    for (int j = 0; j < countX / 4; j++) {
                        result.append(polyominos[0]);
                    }
                    countX = countX % 4;
                }

                for (int j = 0; j < countX / 2; j++) {
                    result.append(polyominos[1]);
                }

                countX = 0;
                result.append('.');
            }
        }

        if (countX != 0) {
            if (countX % 2 != 0) {
                System.out.println(-1);
                return;
            }

            if (countX > 2) {
                for (int j = 0; j < countX / 4; j++) {
                    result.append(polyominos[0]);
                }
                countX = countX % 4;
            }

            for (int j = 0; j < countX / 2; j++) {
                result.append(polyominos[1]);
            }
        }

        System.out.println(result);
    }

}