import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> banCount = new HashMap<>();
        Map<String, Set<String>> banList = new HashMap<>();
        
        for (int i = 0; i < report.length; i++) {
            String[] now = report[i].split(" ");
            
            String from = now[0];
            String to = now[1];
         
            if (!banList.containsKey(from)) {
                banList.put(from, new HashSet<>());
            }
            
            if (!banCount.containsKey(to)) {
                banCount.put(to, 0);
            }
            
            Set<String> reportIds = banList.get(from);
            
            if (!reportIds.contains(to)) {
            	banCount.put(to, banCount.get(to) + 1);
            }
            
            reportIds.add(to);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
         
            Set<String> reportIds = banList.get(id);
            if (reportIds == null) {
                continue;
            }
            
            for (String reportId : reportIds) {
                if (banCount.containsKey(reportId)) {
                    int c = banCount.get(reportId);
                    
                    if (c >= k) {
                        answer[i]++;
                    }
                }
            }
            
        }
        
        return answer;
    }
}