import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String[] numbers = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        char[] n = br.readLine().toCharArray();

        if (n[0] == '0' && n.length == 1) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            String nowNumber = numbers[Integer.parseInt(String.valueOf(n[i]))];

            if (i == 0) {
                boolean flag = false;

                for (int j = 0; j < nowNumber.length(); j++) {
                    if (nowNumber.toCharArray()[j] == '0' && !flag) {
                        continue;
                    } else {
                        flag = true;
                        sb.append(nowNumber.toCharArray()[j]);
                    }
                }
            } else {
                sb.append(nowNumber);
            }
        }

        System.out.println(sb);
    }
}
