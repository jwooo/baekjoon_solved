import java.util.*;

class Solution {
    
    static Map<Long, Long> parent = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            long requestRoom = room_number[i];
            
            long assignedRoom = find(requestRoom);
            answer[i] = assignedRoom;
        }
        
        return answer;
    }
    
    private long find(long room) {
        if (!parent.containsKey(room)) {
            parent.put(room, room + 1);
            return room;
        }
        
        long nextEmptyRoom = find(parent.get(room));
        parent.put(room, nextEmptyRoom);
        return nextEmptyRoom;
    }
}