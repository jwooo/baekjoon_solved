import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (!park[i][j].equals("-1")) continue;
                
                for (int k = 0; k < mats.length; k++) {
                    if (isSpread(i, j, mats[k], park)) {
                        answer = Math.max(answer, mats[k]);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean isSpread(int y, int x, int size, String[][] park) {
        if (y + size > park.length || x + size > park[0].length) return false;
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (i >= park.length || j >= park[i].length) return false;
                if (!park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
}