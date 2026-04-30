class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        long W = w;
        long H = h;
        
        return W * H - (W + H - gcd(W, H));
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}