import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        int now = k;
        
        for (String c : cmd) {
            char op = c.charAt(0);
            
            if (op == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    now = prev[now];
                }
            } else if (op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    now = next[now];
                }
            } else if (op == 'C') {
                removed[now] = true;
                stack.push(now);
                
                if (prev[now] != -1) next[prev[now]] = next[now];
                if (next[now] != n) prev[next[now]] = prev[now];
                
                now = (next[now] != n) ? next[now] : prev[now];
            } else if (op == 'Z') {
                int restore = stack.pop();
                removed[restore] = false;
                
                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != n) prev[next[restore]] = restore;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (removed[i]) sb.append('X');
            else sb.append('O');
        }
        
        return sb.toString();
    }
}