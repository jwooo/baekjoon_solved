import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = replaceSharp(m);
        
        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = replaceSharp(parts[3]);
            
            int playTime = getTimeDifference(start, end);
            String playedMelody = getPlayedMelody(melody, playTime);
            
            if (playedMelody.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
    
    private String getPlayedMelody(String melody, int playTime) {
        int size = melody.length();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % size));
        }
        
        return sb.toString();
    }
    
    private int getTimeDifference(String startTime, String endTime) {
        return extractTime(endTime) - extractTime(startTime);
    }
    
    private int extractTime(String strTime) {
        String[] times = strTime.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    
    private String replaceSharp(String melody) {
        return melody.replaceAll("A#", "a")
            .replaceAll("B#", "b")
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("E#", "e")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g");
    }
}