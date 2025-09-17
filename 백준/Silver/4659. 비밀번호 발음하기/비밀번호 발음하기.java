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

    static String acceptSentence = "<%s> is acceptable.";
    static String notAcceptSentence = "<%s> is not acceptable.";

    public void solution() throws IOException {
        String now = "";
        while (!(now = br.readLine()).equals("end")) {
            char prev = now.charAt(0);
            int count = 1;
            boolean isPrevVowel = isVowelChar(prev);
            boolean hasVowel = isPrevVowel;
            boolean isContinuous = false;
            boolean hasSameChar = false;

            for (int i = 1; i < now.length(); i++) {
                char c = now.charAt(i);
                boolean isNowCharVowel = isVowelChar(c);

                if (!hasVowel) {
                    hasVowel = isNowCharVowel;
                }

                if (isNowCharVowel) { // 현재 글자가 모음 (a,e,i,o,u)인 경우
                    if (isPrevVowel) { // 이전도 vowel인 경우
                        if (++count >= 3) {
                            isContinuous = true;
                            break;
                        }
                    } else { // 이전이 vowel이 아닌 경우
                        isPrevVowel = isNowCharVowel;
                        count = 1;
                    }
                } else { // 현재 글자가 자음인 경우
                    if (isPrevVowel) {
                        isPrevVowel = isNowCharVowel;
                        count = 1;
                    } else {
                        if (++count >= 3) {
                            isContinuous = true;
                            break;
                        }
                    }
                }

                if (prev == c && c != 'e' && c != 'o') {
                    hasSameChar = true;
                    break;
                }

                prev = c;
            }

            if (hasVowel && !isContinuous && !hasSameChar) {
                System.out.println(String.format(acceptSentence, now));
            } else {
                System.out.println(String.format(notAcceptSentence, now));
            }
        }
    }

    private boolean isVowelChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
