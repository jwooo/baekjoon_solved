import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> crewArrivalTimes = new PriorityQueue<>();
        for (String time : timetable) {
            crewArrivalTimes.offer(getTime(time));
        }

        int lastConTime = 0; 

        for (int i = 0; i < n; i++) {
            int busDepartureTime = getTime("09:00") + (i * t);
            int boardedCount = 0;
            int lastBoardedCrewTime = 0; 

            while (!crewArrivalTimes.isEmpty() && boardedCount < m && crewArrivalTimes.peek() <= busDepartureTime) {
                lastBoardedCrewTime = crewArrivalTimes.poll(); 
                boardedCount++; 
            }

            if (i == n - 1) { 
                if (boardedCount < m) {
                    lastConTime = busDepartureTime;
                } else {
                    lastConTime = lastBoardedCrewTime - 1;
                }
            }
        }
        
        return convertToString(lastConTime);
    }

    public int getTime(String strTime) {
        String[] times = strTime.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String convertToString(int time) {
        StringBuilder timeBuilder = new StringBuilder();
        int hour = time / 60;
        int minute = time % 60;

        String strHour = hour < 10 ? "0" + hour : String.valueOf(hour);
        String strMinute = minute < 10 ? "0" + minute : String.valueOf(minute);

        timeBuilder.append(strHour).append(":").append(strMinute);
        return timeBuilder.toString();
    }
}