class Solution {
    public boolean solution(String s) {
        int size = s.length();
        
        if (size != 4 && size != 6) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            
            if (!Character.isDigit(c)) {
                return false;
            }
        } 
        
        return true;
    }
}