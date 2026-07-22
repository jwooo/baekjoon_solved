import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int[][] giftCount = new int[n][n];
        int[] giftScore = new int[n];
        
        for (String gift : gifts) {
            String[] s = gift.split(" ");
            
            int from = map.get(s[0]);
            int to = map.get(s[1]);
            
            giftCount[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }
        
        int[] receive = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftCount[i][j] > giftCount[j][i]){
                    receive[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    receive[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        receive[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        receive[j]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int x : receive) {
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
}