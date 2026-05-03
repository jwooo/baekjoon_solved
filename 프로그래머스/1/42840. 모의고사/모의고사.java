import java.util.*;

class Solution {
    
    private static int[][] PATTERNS = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {
        int[] scores = new int[PATTERNS.length];
        
        for (int i = 0; i < PATTERNS.length; i++) {
            scores[i] = countCorrect(PATTERNS[i], answers);
        }
        
        int max = Arrays.stream(scores).max().orElse(0);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int countCorrect(int[] pattern, int[] answers) {
        int count = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (pattern[i % pattern.length] == answers[i]) {
                count++;
            }
        }
        
        return count;
    }
}