import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int lastNumber = 0;
        
        Map<String, Integer> dictionary = new HashMap<>();
        Deque<String> queue = new LinkedList<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), ++lastNumber);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            queue.offer(String.valueOf(msg.charAt(i)));
        }
        
        while (!queue.isEmpty()) {
            StringBuilder now = new StringBuilder(queue.poll());
            
            while (!queue.isEmpty()) {
                String appendWord = now.toString() + queue.peek();
                
                if (dictionary.containsKey(appendWord)) {
                    String nextWord = queue.poll();
                    now.append(nextWord);
                } else {
                    dictionary.put(appendWord, ++lastNumber);
                    break;
                }
            }
         
            answer.add(dictionary.get(now.toString()));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}