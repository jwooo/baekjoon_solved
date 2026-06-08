class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchingCount = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    matchingCount++;
                    break;
                } 
            }
        }
        
        int minCount = matchingCount;
        int maxCount = matchingCount + zeroCount;
        
        int minRanking = getRanking(minCount);
        int maxRanking = getRanking(maxCount);
        
        return new int[] {maxRanking, minRanking};
    }
    
    static int getRanking(int count) {
        if (count == 6) {
            return 1;
        } else if (count == 5) {
            return 2;
        } else if (count == 4) {
            return 3;
        } else if (count == 3) {
            return 4;
        } else if (count == 2) {
            return 5;
        } else {
            return 6;
        }
    }
    
}