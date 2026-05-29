import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();

        for (int i = 0; i <= t.length() - size; i++) {
            String sub = t.substring(i, i + size);

            if (sub.compareTo(p) <= 0) {
                answer++;
            }
        }

        return answer;
    }
}