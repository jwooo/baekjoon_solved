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

    public void solution() throws IOException {
        char[] words = br.readLine().toCharArray();

        int index = 0;
        while (index < words.length) {
            int soundSize = getSoundSize(index, words);

            if (soundSize == -1) {
                System.out.println("NO");
                return;
            }

            index += soundSize;
        }

        System.out.println("YES");
    }

    private int getSoundSize(int index, char[] words) {
        if (isValidSize(index, 1, words.length)) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[index]).append(words[index + 1]);

        String sound = sb.toString();

        if (sound.equals("pi")) {
            return 2;
        } else if (sound.equals("ka")) {
            return 2;
        } else {
            if (isValidSize(index, 2, words.length)) {
                return -1;
            }

            sb.append(words[index + 2]);
            sound = sb.toString();
            
            if (sound.equals("chu")) {
                return 3;
            }

            return -1;
        }
    }
    
    private boolean isValidSize(int index, int size, int length) {
        return index + size >= length;
    }


}
