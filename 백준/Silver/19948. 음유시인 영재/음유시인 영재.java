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
        String line = br.readLine();

        int enter = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] alphabets = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabets[i] = Integer.parseInt(st.nextToken());
        }

        if (!line.isEmpty()) {
            char firstChar = line.charAt(0);
            if (firstChar == ' ') {
                enter--;
            } else {
                alphabets[Character.toLowerCase(firstChar) - 'a']--;
            }

            for (int i = 1; i < line.length(); i++) {
                char now = line.charAt(i);
                char before = line.charAt(i - 1); 

                if (now != before) {
                    if (now == ' ') {
                        enter--;
                    } else {
                        alphabets[Character.toLowerCase(now) - 'a']--;
                    }
                }
            }
        }

        if (enter < 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] < 0) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] words = line.split(" "); 
        for (String word : words) {
            if (!word.isEmpty()) { 
                sb.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        
        String title = sb.toString();
        for (char titleChar : title.toCharArray()) {
            alphabets[Character.toLowerCase(titleChar) - 'a']--;
        }

        if (enter < 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(title);
    }
}