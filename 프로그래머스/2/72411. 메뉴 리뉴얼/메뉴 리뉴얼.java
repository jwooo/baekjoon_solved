import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] now = orders[i].split("");
            Arrays.sort(now);
            findCourses(now, sb, 0);
        }
        
        for (int i = 0; i < course.length; i++) {
            int courseCount = course[i];
            int maxMenuCount = 0;
            List<String> menu = new ArrayList<>();
            
            for (String key : map.keySet()) {
                int count = map.get(key);
                
                if (key.length() == courseCount && count >= 2) {
                    if (count == maxMenuCount) menu.add(key);
                    else if (count > maxMenuCount) {
                        menu.clear();
                        maxMenuCount = count;
                        menu.add(key);
                    }
                }
            }
            
            if (!menu.isEmpty()) answer.addAll(menu);
        }
        
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }
    
    private void findCourses(String[] order, StringBuilder sb, int nowIndex) {
        if (sb.length() >= 2) map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        if (nowIndex >= order.length) return;
        
        for (int i = nowIndex; i < order.length; i++) {
            sb.append(order[i]);
            findCourses(order, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    
}