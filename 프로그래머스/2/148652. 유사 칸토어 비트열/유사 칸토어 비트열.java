class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for (long i = l - 1; i <= r - 1; i++) {
            if (isOne(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isOne(long idx) {
        while (idx > 0) {
            if (idx % 5 == 2) {
                return false;
            }
            
            idx /= 5;
        }
        
        return true;
    }
}