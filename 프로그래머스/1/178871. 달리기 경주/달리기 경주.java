import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for (String call : callings) {
            int index = rank.get(call);
            
            String frontPlayer = players[index - 1];
            
            players[index - 1] = call;
            players[index] = frontPlayer;
            
            rank.put(call, index - 1);
            rank.put(frontPlayer, index);
        }
        
        return players;
    }
}