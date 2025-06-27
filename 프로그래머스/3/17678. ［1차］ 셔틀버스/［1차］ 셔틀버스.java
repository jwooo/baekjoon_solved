import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Bus> buses = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0, startTime = getTime("09:00"); i < n; i++, startTime += t) {
            buses.add(new Bus(startTime, 0, 0));
        }
        
        for (int i = 0; i < timetable.length; i++) {
            pq.offer(getTime(timetable[i]));
        }
        
        while (!pq.isEmpty()) {
            int userTime = pq.poll();
            
            for (int i = 0; i < n; i++) {
                Bus nowBus = buses.get(i);
                
                if (nowBus.isRidable(userTime, m)) {
                    nowBus.ride(userTime);
                    break;
                }
            }
        }
        
        Bus lastBus = buses.get(buses.size() - 1);
        
        if (lastBus.count == m) {
            answer = convertToString(lastBus.lastCrewTime - 1);
        } else {
            answer = convertToString(lastBus.startTime);
        }
        
        return answer;
    }
    
    static class Bus implements Comparable<Bus> {
        int startTime;
        int lastCrewTime;
        int count;
        
        public Bus(int startTime, int lastCrewTime, int count) {
            this.startTime = startTime;
            this.lastCrewTime = lastCrewTime;
            this.count = count;
        }
        
        public void ride(int rideTime) {
            this.lastCrewTime = Math.max(this.lastCrewTime, rideTime);
            this.count++;
        }
        
        public boolean isRidable(int rideTime, int m) {
            return rideTime <= startTime && !isFull(m);
        }
        
        private boolean isFull(int max) {
            return this.count == max;
        }
        
        @Override
        public int compareTo(Bus o) {
            return this.startTime - o.startTime;
        }
        
        @Override
        public String toString() {
            return "\nBus {startTime=" + startTime + ", lastCrewTime=" + lastCrewTime + ", count=" + count + "}\n";
        }
    }
    
    public int getTime(String strTime) {
        String[] times = strTime.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
    
    public String convertToString(int time) {
        StringBuilder timeBuilder = new StringBuilder();
     
       	int hour = time / 60;
        int minute = time % 60;
        
        String strHour = hour < 10 ? String.valueOf("0" + hour) : String.valueOf(hour);
        String strMinute = minute < 10 ? String.valueOf("0" + minute) : String.valueOf(minute);
        
        timeBuilder.append(strHour).append(":").append(strMinute);
        
        return timeBuilder.toString();
    }
}