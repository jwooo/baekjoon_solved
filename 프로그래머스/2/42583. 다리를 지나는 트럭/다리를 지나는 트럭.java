import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowBridgeWeight = 0;
        
        Queue<Integer> truckWeights = new LinkedList<>();
        Queue<int[]> nowBridge = new LinkedList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            truckWeights.offer(truck_weights[i]);
        }
        
        while (!nowBridge.isEmpty() || !truckWeights.isEmpty()) {
            if (!nowBridge.isEmpty()) {
                int[] firstTruck = nowBridge.peek();
                
                if (answer - firstTruck[1] == bridge_length) {
                    int[] outTruck = nowBridge.poll();
                    nowBridgeWeight -= outTruck[0];
                }
            } 
            
            if (!truckWeights.isEmpty()) {
                int firstTruck = truckWeights.peek();
                
                if (firstTruck + nowBridgeWeight <= weight && nowBridge.size() <= bridge_length) {
                    int inTruck = truckWeights.poll();
                    
                    nowBridgeWeight += inTruck;
                    nowBridge.offer(new int[]{inTruck, answer});
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}