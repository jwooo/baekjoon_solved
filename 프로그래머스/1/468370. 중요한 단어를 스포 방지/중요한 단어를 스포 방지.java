import java.util.*;

class Solution {
    
    static class Word {
        String text;
        int start;
        int end;

        public Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        List<Word> words = new ArrayList<>();
        int len = message.length();
        int wordStart = -1;
        
        for (int i = 0; i <= len; i++) {
            if (i == len || message.charAt(i) == ' ') {
                if (wordStart != -1) {
                    String text = message.substring(wordStart, i);
                    words.add(new Word(text, wordStart, i - 1));
                    wordStart = -1;
                }
            } else {
                if (wordStart == -1) {
                    wordStart = i;
                }
            }
        }
        
        Set<String> nonSpoilerWords = new HashSet<>();
        
        List<List<String>> clickedGroups = new ArrayList<>();
        for (int i = 0; i < spoiler_ranges.length; i++) {
            clickedGroups.add(new ArrayList<>());
        }
        
        for (Word word : words) {
            boolean isSpoilerWord = false;
            
            for (int i = 0; i < spoiler_ranges.length; i++) {
                int spStart = spoiler_ranges[i][0];
                int spEnd = spoiler_ranges[i][1];
                
                if (word.start <= spEnd && word.end >= spStart) {
                    isSpoilerWord = true;
                    clickedGroups.get(i).add(word.text);
                }
            }
            
            if (!isSpoilerWord) {
                nonSpoilerWords.add(word.text);
            }
        }
        
        Set<String> revealedSpoilerWords = new HashSet<>();
        
        for (List<String> group : clickedGroups) {
            for (String w : group) {
                if (!nonSpoilerWords.contains(w) && !revealedSpoilerWords.contains(w)) {
                    answer++;
                }
                
                revealedSpoilerWords.add(w);
            }
        }
        
        return answer;
    }
}