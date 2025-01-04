import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            String now = sb.toString();
            for (int j = 0; j < now.length(); j++) {
                Character nowValue = now.charAt(j);
                
                if (stack.isEmpty()) stack.push(nowValue);
                else if (stack.peek() == '(' && nowValue == ')') stack.pop();
                else if (stack.peek() == '{' && nowValue == '}') stack.pop();
                else if (stack.peek() == '[' && nowValue == ']') stack.pop();
                else stack.push(nowValue);
            }
            
            if (stack.isEmpty()) answer++;
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            stack.clear();
        }
        
        return answer;
    }
}