import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static String[] firstWords = {"c", "j", "n", "m", "t", "s", "l", "d", "qu"};
    static String[] vowels = {"a", "e", "i", "o", "u", "h"};

    public void solution() throws IOException {
        String word = br.readLine();

        List<String> splitWordBySpaceAndHyphen = splitBySpaceAndHyphen(word);
        List<String> answer = splitByApostrophe(splitWordBySpaceAndHyphen);

        System.out.println(answer.size());
    }

    private List<String> splitByApostrophe(List<String> words) {
        List<String> splitWords = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            String[] s = words.get(i).split("'");

            if (s.length > 1) {
                if (hasFirstWord(s[0]) && isVowel(s[1])) {
                    splitWords.add(s[0]);
                    splitWords.add(s[1]);
                } else {
                    splitWords.add(words.get(i));
                }
            } else {
                splitWords.add(words.get(i));
            }
        }

        return splitWords;
    }

    private boolean hasFirstWord(String word) {
        for (String firstWord : firstWords) {
            if (word.equals(firstWord)) {
                return true;
            }
        }

        return false;
    }

    private boolean isVowel(String word) {
        for (String vowel : vowels) {
            if (word.startsWith(vowel)) {
                return true;
            }
        }

        return false;
    }

    private List<String> splitBySpaceAndHyphen(String word) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ' || word.charAt(i) == '-') {
                words.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(word.charAt(i));
            }
        }

        words.add(sb.toString());

        return words;
    }

}