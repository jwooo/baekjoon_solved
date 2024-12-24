import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Queue<Event> events = new LinkedList<>();
        Map<String, String> nicknames = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] now = record[i].split(" ");
            Event nowEvent = Event.of(now[0], now[1]);
            
            if (nowEvent.isEnter()) {
                nicknames.put(nowEvent.getUserId(), now[2]);
                events.offer(nowEvent);
            } else if (nowEvent.isLeave()) {
                events.offer(nowEvent);
            } else {
                nicknames.put(nowEvent.getUserId(), now[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        while (!events.isEmpty()) {
            Event nowEvent = events.poll();
            String nickname = nicknames.get(nowEvent.getUserId());
            
            answer.add(nickname + "님이 " + nowEvent.getEventTypeToKor());
        }
        
        return answer.stream().toArray(String[]::new);
    }
    
    static class Event {
        private String eventType;
        private String userId;
        
        public Event(String eventType, String userId) {
            this.eventType = eventType;
            this.userId = userId;
        }
        
        public static Event of(String eventType, String userId) {
            return new Event(eventType, userId);
        }
        
        public String getEventType() {
            return this.eventType;
        }
        
        public String getEventTypeToKor() {
            if (isEnter()) return "들어왔습니다.";
            else if (isLeave()) return "나갔습니다.";
            else return null;
        }
        
        public String getUserId() {
            return this.userId;
        }
        
        public boolean isEnter() {
            return eventType.equals("Enter");
        }
        
        public boolean isLeave() {
            return eventType.equals("Leave");
        }
        
        public boolean isChange() {
            return eventType.equals("Change");
        }
    }
}