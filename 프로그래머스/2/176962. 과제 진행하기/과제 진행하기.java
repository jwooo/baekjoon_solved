import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<Pair> remainTask = new Stack<>();
        
        Arrays.sort(plans, (x, y) -> getTime(x[1]) - getTime(y[1]));
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int nowTime = getTime(plans[i][1]);
            int remainTime = Integer.parseInt(plans[i][2]);
            
            if (i == plans.length - 1) answer.add(name);
            else {
                int nextTime = getTime(plans[i + 1][1]);
                int timeDiffrence = nextTime - nowTime;
                
                remainTask.push(Pair.of(name, remainTime));
                
                while (!remainTask.isEmpty() && timeDiffrence > 0) {
                    Pair now = remainTask.pop();
                    int minTime = Math.min(timeDiffrence, now.getRemainTime());
                    
                    if (minTime == now.getRemainTime()) answer.add(now.getName());
                    else remainTask.push(Pair.of(now.getName(), now.getRemainTime() - minTime));
                    
                    timeDiffrence = timeDiffrence - minTime;
                }
            }
        }
        
        while (!remainTask.isEmpty()) answer.add(remainTask.pop().getName());
        
        return answer.toArray(String[]::new);
    }
    
    	public int getTime(String stringTime) {
		String[] time = stringTime.split(":");
		return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
	}
	
	public static class Pair {
		private String name;
		private int remainTime;
		
		public Pair(String name, int remainTime) {
			this.name = name;
			this.remainTime = remainTime;
		}
		
		public String getName() {
			return name;
		}
		
		public int getRemainTime() {
			return remainTime;
		}
        
        public static Pair of(String name, int remainTime) {
            return new Pair(name, remainTime);
        }
	}
}