class Solution {
    
    private static final String[] ACCENT = new String[]{"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            String now = babbling[i];
         
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < now.length(); j++) {
                sb.append(now.charAt(j));
                
                if (sb.length() > 3) break;
                for (int k = 0; k < ACCENT.length; k++) {
                    if (ACCENT[k].equals(sb.toString())) {
                        sb = new StringBuilder();
                    }
                }
            }
            
            if (sb.length() == 0) answer++;
        }
        
        return answer;
    }
}