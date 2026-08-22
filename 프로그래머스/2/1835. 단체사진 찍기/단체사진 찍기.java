import java.util.*;

class Solution {
    
    Map<Character, Integer> map;
    String[] conditions;
    boolean[] visited;
    int[] arr;
    int answer;

    public int solution(int n, String[] data) {
        answer = 0;
        conditions = data;
        visited = new boolean[8];
        arr = new int[8];
        
        map = new HashMap<>();
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        for (int i = 0; i < 8; i++) {
            map.put(friends[i], i);
        }

        dfs(0);
        return answer;
    }

    private void dfs(int depth) {
        if (depth == 8) {
            if (check()) {
                answer++;
            }
            
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean check() {
        for (String cond : conditions) {
            int p1 = map.get(cond.charAt(0));
            int p2 = map.get(cond.charAt(2));
            char op = cond.charAt(3);        
            int targetDist = cond.charAt(4) - '0';

            int pos1 = -1, pos2 = -1;
            
            for (int i = 0; i < 8; i++) {
                if (arr[i] == p1) pos1 = i;
                if (arr[i] == p2) pos2 = i;
            }

            int dist = Math.abs(pos1 - pos2) - 1;

            if (op == '=') {
                if (dist != targetDist) return false;
            } else if (op == '<') {
                if (dist >= targetDist) return false;
            } else if (op == '>') {
                if (dist <= targetDist) return false;
            }
        }
        return true;
    }
}