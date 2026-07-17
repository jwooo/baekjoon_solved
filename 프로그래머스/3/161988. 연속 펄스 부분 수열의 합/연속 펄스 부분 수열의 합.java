class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long sumA = 0;
        long sumB = 0; 
        
        long maxVal = Long.MIN_VALUE;
        
        int pulse = 1;
        for (int i = 0; i < n; i++) {
            long valA = (long) sequence[i] * pulse;
            long valB = (long) sequence[i] * (-pulse);
            
            sumA = Math.max(valA, sumA + valA);
            sumB = Math.max(valB, sumB + valB);
            
            maxVal = Math.max(maxVal, Math.max(sumA, sumB));
            
            pulse *= -1;
        }
        
        return maxVal;
    }
}