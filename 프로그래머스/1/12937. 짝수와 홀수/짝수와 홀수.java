class Solution {
    
    static final String odd = "Odd";
    static final String even = "Even";
    
    public String solution(int num) {
        return num % 2 == 0 ? even : odd;
    }
}