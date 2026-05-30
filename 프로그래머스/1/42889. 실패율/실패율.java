import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];
        
        for (int stage : stages) {
            count[stage]++;
        }
        
        int remain = stages.length;
        List<Stage> list = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            double failRate = 0;
         
            if (remain != 0) {
                failRate = (double) count[i] / remain;
            }
            
            list.add(new Stage(i, failRate));
            remain -= count[i];
        }
        
        Collections.sort(list, (a, b) -> {
            if (Double.compare(b.failRate, a.failRate) == 0) {
                return a.number - b.number;
            }
            
            return Double.compare(b.failRate, a.failRate);
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).number;
        }
        
        return answer;
    }
    
    static class Stage {
        int number;
        double failRate;
        
        Stage(int number, double failRate) {
            this.number = number;
            this.failRate = failRate;
        }
    }
    
}