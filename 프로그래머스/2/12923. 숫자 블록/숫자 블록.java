class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        
        for (long i = begin; i <= end; i++) {
            answer[(int) (i - begin)] = (int) calculate(i);
        }
        
        return answer;
    }
    
    private static long calculate(long num) {
        if (num == 1) return 0;
        
        int result = 1;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i <= 10000000) {
                    return Math.max(result, (int) (num / i));
                } else {
                    result = Math.max(result, i);
                }
            }
        }
        
        return result;
    }
}