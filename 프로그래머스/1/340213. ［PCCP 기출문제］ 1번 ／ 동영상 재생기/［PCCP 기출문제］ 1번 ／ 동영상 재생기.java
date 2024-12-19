import java.util.*;

class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoSize = convertToSecond(video_len);
        int now = convertToSecond(pos);
        int opStart = convertToSecond(op_start);
        int opEnd = convertToSecond(op_end);
        
        if (now >= opStart && now <= opEnd) now = opEnd;
        
        for (String command : commands) {
            if (command.equals("next")) now = now + 10 > videoSize ? videoSize : now + 10;
            else now = now - 10 < 0 ? 0 : now - 10;
            
            if (now >= opStart && now <= opEnd) now = opEnd;
        }
        
		int minute = now / 60;
        int second = now % 60;
        
        answer += minute < 10 ? "0" + minute : "" + minute;
        answer += ":";
        answer += second < 10 ? "0" + second : "" + second;
        
        return answer;
    }
    
    private int convertToSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
}