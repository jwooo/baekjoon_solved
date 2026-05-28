class Solution {
    
    static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        while (s.length() > 0) {
            boolean isWord = false;
            
            for (int i = 0; i < words.length; i++) {
                if (s.startsWith(words[i])) {
                    isWord = true;
                    sb.append(i);
                    s = s.substring(words[i].length(), s.length());
                    break;
                }
            }
            
            if (!isWord) {
                sb.append(s.charAt(0));
                s = s.substring(1, s.length());
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}