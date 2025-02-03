import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answers = new ArrayList<>();
        
        for (long i = left; i <= right; i++) {
            if (i / n <= i % n) answers.add((int) (i % n) + 1);
            else answers.add((int) (i / n) + 1);
        }
        
        int[] answer = new int[answers.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}