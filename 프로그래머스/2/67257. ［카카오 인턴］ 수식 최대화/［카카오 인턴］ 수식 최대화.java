import java.util.*;

class Solution {
    static long answer = 0;
    static String[] o = {"+", "-", "*"};
    static List<String> exp = new ArrayList<>();
    static Set<String> operators = new HashSet<>();
    
    public long solution(String expression) {
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);
            
            if (Character.isDigit(now)) numberBuilder.append(now);
            else {
                String op = String.valueOf(now);
                operators.add(op);
                
                exp.add(numberBuilder.toString());
                exp.add(op);
                numberBuilder.delete(0, numberBuilder.length());
            }
        }
        exp.add(numberBuilder.toString());
        
        boolean[] visited = new boolean[3];
        return dfs(0, visited, new ArrayList<>());
    }
    
   	private long dfs(int depth, boolean[] visited, List<String> priority) {
        if (depth == operators.size()) {
            Deque<String> deque = new ArrayDeque<>(exp);
            Stack<String> stack = new Stack<>();
            
            for (int i = 0; i < priority.size(); i++) {
                String p = priority.get(i);
                
                while (!deque.isEmpty()) {
                    String nowExp = deque.poll();
                    
                    if (!nowExp.equals(p)) stack.push(nowExp);
                    else {
                        Long prev = Long.valueOf(stack.pop());
                        Long next = Long.valueOf(deque.poll());
                        
                        stack.push(String.valueOf(calc(prev, next, nowExp)));
                    }
                }
                
                while (!stack.isEmpty()) {
                    deque.addFirst(stack.pop());
                }
            }
            
            return Math.abs(Long.valueOf(deque.poll()));
        }
        
        for (int i = 0; i < 3; i++) {
            if (!visited[i] && operators.contains(o[i])) {
                priority.add(o[i]);
                visited[i] = true;
                
                answer = Math.max(dfs(depth + 1, visited, priority), answer);
                
                priority.remove(o[i]);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    private long calc(Long prev, Long next, String op) {
        if (op.equals("+")) return prev + next;
        else if (op.equals("-")) return prev - next;
        else return prev * next;
    }
    
}