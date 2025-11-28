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

    public void solution() throws IOException {
        char[] chars = br.readLine().toCharArray();

        int zeroCount = 0;
        int oneCount = 0;
        for (char c : chars) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        int zerosToRemove = zeroCount / 2;
        int onesToRemove = oneCount / 2;

        boolean[] removed = new boolean[chars.length];
        int onesRemovedCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (onesRemovedCount < onesToRemove && chars[i] == '1') {
                removed[i] = true;
                onesRemovedCount++;
            }
        }

        int zerosRemovedCount = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (zerosRemovedCount < zerosToRemove && chars[i] == '0') {
                removed[i] = true;
                zerosRemovedCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!removed[i]) {
                result.append(chars[i]);
            }
        }

        System.out.println(result.toString());
    }

}