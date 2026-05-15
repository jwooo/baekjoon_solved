class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < phone_number.length(); i++) {
            char now = phone_number.charAt(i);
         
            if (i >= phone_number.length() - 4) {
                sb.append(now);
            } else {
                sb.append('*');
            }
        }
        
        return sb.toString();
    }
}