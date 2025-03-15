class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = Long.MAX_VALUE;
        long start =1;
        long end = limit;
        
        while (start <= end) {
            long level = (start + end) / 2;
            
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) totalTime += times[i];
                else totalTime += ((times[i] + times[i - 1]) * (diffs[i] - level) + times[i]);
            }
            
            if (limit >= totalTime) {
                answer = Math.min(answer, level);
                end = --level;
            } else {
                start = ++level;
            }
        }
        
        return Integer.parseInt(String.valueOf(answer));
    }
}