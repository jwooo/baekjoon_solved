class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int second = 0;
            
            for (int j = i + 1; j < prices.length; j++) {
                second++;
                if (prices[i] > prices[j]) break;
            }
            
            answer[i] = second;
        }
        
        return answer;
    }
}