import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    public String dfs(String str) {
        if (str.length() == 0) return "";
        
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        
        int now = 0;
        while (!stack.isEmpty()) {
            now++;
            
            if (stack.peek() == '(' && str.charAt(now) == ')') stack.pop();
            else if (stack.peek() == ')' && str.charAt(now) == '(') stack.pop();
            else stack.push(str.charAt(now));
        }
        
        String u = str.substring(0, now + 1);
        String v = str.substring(now + 1, str.length());
        
        if (u.charAt(0) == '(') {
            return u + dfs(v);
        } else {
            StringBuilder answer = new StringBuilder();
            answer.append("(").append(dfs(v)).append(")");
            
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                
                if (c == '(') answer.append(')');
                else answer.append('(');
            }
            
            return answer.toString();
        }
    }
}