class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = findOneValueCount(n);
        
        answer = n + 1;
        while (answer <= 1_000_000) {
            if (count == findOneValueCount(answer)) break;
            else answer++;
        }
        
        return answer;
    }
    
    private int findOneValueCount(int n) {
        int count = 0;
        
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        
        return count;
    }
    
}