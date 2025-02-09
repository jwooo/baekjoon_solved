import java.util.*;

class Solution {
    
    private List<String> words = new ArrayList<>();
    private static final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        generateWords("");
        
        return words.indexOf(word);
    }
    
    private void generateWords(String current) {
        words.add(current);
        
        if (current.length() == 5) return;
        
        for (char vowel : vowels) {
            generateWords(current + vowel);
        }
    }
    
}