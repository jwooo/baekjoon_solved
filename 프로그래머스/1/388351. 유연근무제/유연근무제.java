class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int time = getTime(schedules[i]) + 10;
         
            if (!isLate(startday, time, timelogs[i])) {
               answer++; 
            } 
        }
        
        return answer;
    }
    
    private int getTime(int now) {
        int hour = now / 100 * 60;
        int minute = now % 100;
     
        return hour + minute;
    }
    
    private boolean isLate(int startDay, int time, int[] timelog) {
        for (int i = 0; i < timelog.length; i++) {
            int dayOfWeek = (startDay + i) % 7;
            
            if (dayOfWeek == 0 || dayOfWeek == 6) {
                continue;
            }
            
            if (time < getTime(timelog[i])) {
                return true;
            }
        }
        
        return false;
    }
}