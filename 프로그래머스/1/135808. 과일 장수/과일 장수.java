import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = score.length - 1;
        
        Arrays.sort(score);
        
        while (count - m + 1 >= 0) {
            int minApple = k;
            
            for (int i = count; i > count - m; i--) {
                if (minApple > score[i]) {
                    minApple = score[i];
                }
            }
            
            answer += minApple * m;
            count -= m;
        }
        
        return answer;
    }
}