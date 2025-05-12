import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if (n == 1) return sticker[0];
        
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        
        dp1[1] = sticker[0];
        for (int i = 2; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i - 1]);
        }
        
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i - 1]);
        }
        
        answer = Math.max(dp1[n - 1], dp2[n]);
        return answer;
    }
}