import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {-1, 0});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            String word = now[0] == -1 ? begin : words[now[0]];
            int count = now[1];
            
            for (int i = 0; i < words.length; i++) {
                if (isConvertible(word, words[i])) {
                    if (words[i].equals(target)) return count + 1;
                    else if (!visited[i]) {
                        visited[i] = true;
                        queue.offer(new int[] {i, count + 1});
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean isConvertible(String word, String otherWord) {
        int wrongCount = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != otherWord.charAt(i)) wrongCount++;
        }
        
        return wrongCount <= 1;
    }
}