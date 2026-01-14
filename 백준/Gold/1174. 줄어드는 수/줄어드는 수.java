import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static List<Long> decreasingNumbers = new ArrayList<>();

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            findDecreaseNumbers(i);
        }

        Collections.sort(decreasingNumbers);
        System.out.println(decreasingNumbers.get(n - 1));
    }

    private static void findDecreaseNumbers(long number) {
        decreasingNumbers.add(number);

        long lastDigit = number % 10;

        for (int i = 0; i < lastDigit; i++) {
            long newNum = (number * 10) + i;
            findDecreaseNumbers(newNum);
        }
    }

}
