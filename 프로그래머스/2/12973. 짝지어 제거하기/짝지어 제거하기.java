import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> words = new Stack<>();
        
        for (char now : s.toCharArray()) {
            if (!words.isEmpty() && words.peek().equals(now)) {
                words.pop();
            } else {
                words.push(now);
            }
        }
        
        return words.isEmpty() ? 1 : answer;
    }
}