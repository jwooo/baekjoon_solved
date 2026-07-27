class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int needDelivery = 0;
        int needPickup = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            needDelivery += deliveries[i];
            needPickup += pickups[i];
            
            while (needDelivery > 0 || needPickup > 0) {
                answer += (i + 1) * 2;
                
                needDelivery -= cap;
                needPickup -= cap;
            }
        }
        
        
        return answer;
    }
}