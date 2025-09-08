import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] alphaCounts = new int[26];
        for (char c : name.toCharArray()) {
            alphaCounts[c - 'A']++;
        }

        int oddCount = 0;
        char middleChar = 0;
        for (int i = 0; i < 26; i++) {
            if (alphaCounts[i] % 2 != 0) {
                oddCount++;
                middleChar = (char) ('A' + i);
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder front = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphaCounts[i] / 2; j++) {
                front.append((char) ('A' + i));
            }
        }

        String back = new StringBuilder(front).reverse().toString();
        if (oddCount == 1) {
            front.append(middleChar);
        }
        
        front.append(back);

        System.out.println(front.toString());
    }
}