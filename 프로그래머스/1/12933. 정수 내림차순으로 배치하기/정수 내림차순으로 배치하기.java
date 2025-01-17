import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> list = new ArrayList<>();
        
        while (n / 10 > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        
        list.add(n);
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        
        return Long.valueOf(sb.toString());
    }
}