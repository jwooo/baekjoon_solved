class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long playTime = strToTime(play_time);
        long advTime = strToTime(adv_time);
        
        long[] timeline = new long[(int) playTime + 1];
        
        for (String log : logs) {
            String[] parts = log.split("-");
            
            long start = strToTime(parts[0]);
            long end = strToTime(parts[1]);
            
            timeline[(int) start]++;
            
            if (end <= playTime) timeline[(int) end]--;
        }
        
        for (int i = 1; i <= playTime; i++) {
            timeline[i] += timeline[i - 1];
        }
        
        long[] prefixSum = new long[(int) playTime + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < playTime; i++) {
            prefixSum[i + 1] = prefixSum[i] + timeline[i]; 
        }
        
        long maxTotalTime = 0;
        long optimalAdvStartTime = 0;
        
        maxTotalTime = prefixSum[(int) advTime];
        
        
       for (long currentStartTime = 1; currentStartTime <= playTime - advTime; currentStartTime++) {
           long currentEndTime = currentStartTime + advTime;
           long currentWindowWatchTime = prefixSum[(int) currentEndTime] - prefixSum[(int) currentStartTime];
           
           if (currentWindowWatchTime > maxTotalTime) {
               maxTotalTime = currentWindowWatchTime;
               optimalAdvStartTime = currentStartTime;
           }
       }
        
       return timeToStr(optimalAdvStartTime);
    }
    
    private long strToTime(String time) {
        String[] times = time.split(":");
        
        long hour = Long.parseLong(times[0]);
        long minute = Long.parseLong(times[1]);
        long second = Long.parseLong(times[2]);
        
        return hour * 3600 + minute * 60 + second;
    }
    
    private String timeToStr(long time) {
        long hour = time / 3600;
        time %= 3600;
        
        long minute = time / 60;
        long second = time % 60;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}