class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int x = 1; x <= r2; x++) {
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            
            double y1 = (x < r1) ? Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)) : 0;
            
            long maxY = (long) Math.floor(y2);
            long minY = (long) Math.ceil(y1);
            
            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }
}