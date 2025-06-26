import java.util.*;

class Solution {
    
    static Map<String, String> parents = new HashMap<>();
    static Map<String, Integer> monies = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        parents.put("-", null);
        monies.put("-", 0);
        
        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            monies.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;
            dfs(name, money);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = monies.get(enroll[i]);
        }
        
        return answer;
    }
    
    private void dfs(String name, int money) {
        if (name.equals("-")) return;
        
        String parent = parents.get(name);
        int payment = (int) (money * 0.1);
        
        monies.put(name, monies.get(name) + (money - payment));
        
        if (payment > 0) dfs(parent, payment);
    }
}