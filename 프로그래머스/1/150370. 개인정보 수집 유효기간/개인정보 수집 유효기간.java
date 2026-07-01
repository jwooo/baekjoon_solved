import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        int todayDays = getDays(today);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String dateStr = splitPrivacy[0];
            String termType = splitPrivacy[1];
            
            int collectedDays = getDays(dateStr);
            int expiryDays = collectedDays + (termMap.get(termType) * 28);
            
            if (todayDays >= expiryDays) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private int getDays(String dateStr) {
        String[] splitDate = dateStr.split("\\."); 
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
    
}