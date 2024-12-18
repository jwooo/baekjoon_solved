import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = null;
        
        if (n > s) return new int[] {-1};
        
        answer = new int[n];
        int mod = s % n;
        
        Arrays.fill(answer, s / n);
        
        while (mod-- != 0) {
            answer[--n]++;
        }
        
        return answer;
    }
}