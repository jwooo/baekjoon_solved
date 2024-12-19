import java.util.*;

class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] videoSize = parseToIntArray(video_len);
        int[] now = parseToIntArray(pos);
        int[] openingStart = parseToIntArray(op_start);
        int[] openingEnd = parseToIntArray(op_end);
        
         if (openingStart[0] < now[0] & openingEnd[0] > now[0]) {
             now[0] = openingEnd[0];
             now[1] = openingEnd[1];
         } else if (openingStart[0] == now[0]) {
             if (now[1] >= openingStart[1]) {
                 now[0] = openingEnd[0];
                 now[1] = openingEnd[1];
             }
         } else if (openingEnd[0] == now[0]) {
             if (now[1] <= openingEnd[1]) {
                 now[0] = openingEnd[0];
                 now[1] = openingEnd[1];
             }
         }
        
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            
            if (isNext(command)) {
                int nextSecond = now[1] + 10;
             
                if (nextSecond >= 60) {
                    now[0]++;
                    now[1] = nextSecond - 60;
                } else {
                    now[1] = nextSecond;
                }
                
                if (now[0] > videoSize[0]) {
                    now[0] = videoSize[0];
                    now[1] = videoSize[1];
                } else if (now[0] == videoSize[0]) {
                    if (now[1] > videoSize[1]) {
                        now[1] = videoSize[1];
                    }
                }
                
            } else if (isPrev(command)) {
                int prevSecond = now[1] - 10;
                
                if (prevSecond < 0) {
                    if (now[0] == 0) {
                        now[0] = 0;
                        now[1] = 0;
                    } else {
                        now[0]--;
                        now[1] = 50 + now[1];
                    }
                } else {
                    now[1] = prevSecond;
                }
            }
            
            System.out.println("[NON-CHECK]" + now[0] + ":" + now[1]);
            
            if (openingStart[0] < now[0] & openingEnd[0] > now[0]) {
                now[0] = openingEnd[0];
                now[1] = openingEnd[1];
            } else if (openingStart[0] == now[0] && openingEnd[0] == now[0]) {
                if (now[1] >= openingStart[1] && now[1] <= openingEnd[1]) {
                    now[0] = openingEnd[0];
                    now[1] = openingEnd[1];
                }
            } else if (openingStart[0] == now[0]) {
                if (now[1] >= openingStart[1]) {
                    now[0] = openingEnd[0];
                    now[1] = openingEnd[1];
                }
            } else if (openingEnd[0] == now[0]) {
                if (now[1] <= openingEnd[1]) {
                    now[0] = openingEnd[0];
                    now[1] = openingEnd[1];
                }
            }
            
        }
        
        String mm = now[0] / 10 == 0 ? "0" + now[0] : String.valueOf(now[0]);
        String ss = now[1] / 10 == 0 ? "0" + now[1] : String.valueOf(now[1]);
        
        StringBuilder sb = new StringBuilder();
        answer = sb.append(mm).append(":").append(ss).toString();
        
        System.out.println(sb.toString());
        
        return answer;
    }
    
    private int[] parseToIntArray(String str) {
        return Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
    }
    
    private static boolean isNext(String str) {
        return "next".equals(str);
    }
    
    private static boolean isPrev(String str) {
        return "prev".equals(str);
    }
    
}