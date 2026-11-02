import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(' || now == '[' || now == '{') {
                stack.push(now);
                continue;
            } 

            if (stack.isEmpty()) {
                return false;
            }

            char saved = stack.peek();
            if (isValid(now, saved)) {
                stack.pop();
            } else {
                return false;
            }

        }

        return stack.isEmpty();
    }

    private boolean isValid(char now, char saved) {
        if (saved == '(' && now == ')') {
            return true;
        } else if (saved == '[' && now == ']') {
            return true;
        } else if (saved == '{' && now == '}') {
            return true;
        }

        return false;
    }
}