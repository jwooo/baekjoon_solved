import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> forward = new HashMap<>();
        Map<Integer, List<String>> backward = new HashMap<>();
        
        for (String w : words) {
            int len = w.length();
            forward.computeIfAbsent(len, k -> new ArrayList<>()).add(w);
            backward.computeIfAbsent(len, k -> new ArrayList<>()).add(new StringBuilder(w).reverse().toString());
        }
        
        for (List<String> list : forward.values()) Collections.sort(list);
        for (List<String> list : backward.values()) Collections.sort(list);
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();
            if (!forward.containsKey(len)) {
                answer[i] = 0;
                continue;
            }
            if (q.charAt(0) == '?') {
                String revQ = new StringBuilder(q).reverse().toString();
                String low = revQ.replace('?', 'a');
                String high = revQ.replace('?', '{');
                List<String> list = backward.get(len);
                answer[i] = upperBound(list, high) - lowerBound(list, low);
            } else {
                String low = q.replace('?', 'a');
                String high = q.replace('?', '{');
                List<String> list = forward.get(len);
                answer[i] = upperBound(list, high) - lowerBound(list, low);
            }
        }
        return answer;
    }
    
    private int lowerBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) >= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    private int upperBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) > 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}