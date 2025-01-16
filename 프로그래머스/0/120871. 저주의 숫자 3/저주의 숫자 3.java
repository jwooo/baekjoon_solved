class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while (n > 0) {
            if (answer % 3 != 0 && !String.valueOf(answer).contains("3")) n--; 
            
            answer++;
        }
        
        return answer - 1;
    }
}