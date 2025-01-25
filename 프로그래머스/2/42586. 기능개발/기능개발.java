import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Work> works = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            works.offer(Work.of(progresses[i], speeds[i]));
        }
        
        while (!works.isEmpty()) {
            int workSize = works.size();
            
            for (int i = 0; i < workSize; i++) {
                Work nowWork = works.poll();
                nowWork.updateProgress();
                works.offer(nowWork);
            }
            
            int beforeListSize = answer.size();
            while (!works.isEmpty() && works.peek().getProgress() >= 100) {
                works.poll();
                
                if (answer.size() > beforeListSize) {
                    answer.set(answer.size() - 1, answer.get(answer.size() - 1) + 1);
                } else {
                    answer.add(1);
                }
            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Work {
        private int progress;
        private int speed;
        
        private Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
        
        public int getProgress() {
            return progress;
        }
        
        public int getSpeed() {
            return speed;
        }
        
        public void updateProgress() {
            this.progress += speed;
        }
        
        public static Work of(int progress, int speed) {
            return new Work(progress, speed);
        }
    }
}
