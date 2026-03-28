import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String VOWELS_STR = "aiyeou";
    private static final String CONSONANTS_STR = "bkxznhdcwgpvjqtsrlmf";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            for (char ch : line.toCharArray()) {
                char transformedChar = transformChar(ch);
                result.append(transformedChar);
            }
            result.append("\n");
        }

        System.out.print(result.toString());
        br.close();
    }

    private static char transformChar(char ch) {
        boolean isUpperCase = Character.isUpperCase(ch);
        char lowerCh = Character.toLowerCase(ch);

        int vowelIndex = VOWELS_STR.indexOf(lowerCh);
        if (vowelIndex != -1) {
            int newIndex = (vowelIndex + 3) % VOWELS_STR.length();
            char newChar = VOWELS_STR.charAt(newIndex);
            return isUpperCase ? Character.toUpperCase(newChar) : newChar;
        }

        int consonantIndex = CONSONANTS_STR.indexOf(lowerCh);
        if (consonantIndex != -1) {
            int newIndex = (consonantIndex + 10) % CONSONANTS_STR.length();
            char newChar = CONSONANTS_STR.charAt(newIndex);
            return isUpperCase ? Character.toUpperCase(newChar) : newChar;
        }

        return ch;
    }
}