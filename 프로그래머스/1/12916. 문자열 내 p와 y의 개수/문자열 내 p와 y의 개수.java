class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'p') countP++;
            if (c == 'y') countY++;
        }
        
        return countP == countY;
    }
}