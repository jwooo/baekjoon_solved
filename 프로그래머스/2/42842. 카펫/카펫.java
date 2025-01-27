import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        int vertical = 1;
        
        while (size / vertical >= vertical) {
            if (size % vertical != 0) {
                vertical++;
                continue;
            }
            
            int nowYellowSize = (size / vertical - 2) * (vertical - 2);
            
            if (nowYellowSize == yellow && brown == size - nowYellowSize) {
                answer[0] = size / vertical;
                answer[1] = vertical;
                
                return answer;
            }
            
            vertical++;
        }
        
        return answer;
    }
}