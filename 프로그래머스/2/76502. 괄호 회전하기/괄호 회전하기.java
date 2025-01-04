import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        List<Character> now = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            now.add(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                Character nowChar = now.get(j);
                
                if (stack.isEmpty()) {
                    stack.push(nowChar);
                } else if (stack.peek() == '(' && nowChar == ')') {
                    stack.pop();
                } else if (stack.peek() == '{' && nowChar == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && nowChar == ']') {
                    stack.pop();
                } else {
                    stack.push(nowChar);
                }
            }
            
            if (stack.isEmpty()) answer++;
            now.add(now.remove(0));
            stack.clear();
        }
        
        return answer;
    }
}