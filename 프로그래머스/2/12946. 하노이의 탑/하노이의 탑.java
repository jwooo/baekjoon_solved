import java.util.*;

class Solution {
    
    static List<Integer[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(1, 3, 2, n);
        
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Integer[] now = result.get(i);
            
            answer[i][0] = now[0];
            answer[i][1] = now[1];
        }
        
        
        return answer;
    }
    
    private void hanoi(int start, int end, int mid, int n) {
        if (n == 1) {
            result.add(new Integer[]{start, end});
        } else {
            hanoi(start, mid, end, n - 1);
            result.add(new Integer[]{start, end});
            hanoi(mid, end, start, n - 1);
        }
    }
    
}