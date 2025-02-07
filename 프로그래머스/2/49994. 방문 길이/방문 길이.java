import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> visitedPath = new HashSet<>();
        
        String[] events = dirs.split("");
        for (int i = 0; i < events.length; i++) {
            String event = events[i];
            
            int newX = x;
            int newY = y;
            
            if (event.equals("U")) newY++;
            else if (event.equals("D")) newY--;
            else if (event.equals("R")) newX++;
            else if (event.equals("L")) newX--;
            
            if (newX < -5 || newX > 5 || newY < -5 || newY > 5) continue;
            String path;
            if (x < newX || (x == newX && y < newY)) 
                path = x + ", " + y + "->" + newX + ", " + newY;
            else 
                path = newX + ", " + newY + "->" + x + ", " + y;
            
            visitedPath.add(path);
            
            x = newX;
            y = newY;
        }
        
        return visitedPath.size();
    }
}