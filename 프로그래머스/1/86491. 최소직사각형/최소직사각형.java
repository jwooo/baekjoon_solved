import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] s = new int[2];
        for (int[] size : sizes) {
            if (s[0] == 0 && s[1] == 0) {
                s[0] = size[0];
                s[1] = size[1];
                continue;
            }
            
            compare(s, size);
        }
        
        return s[0] * s[1];
    }
    
 
    private void compare(int[] oldSize, int[] newSize) {
        int width = oldSize[0];
        int height = oldSize[1];
     
        int w1 = Math.max(width, newSize[0]);
        int h1 = Math.max(height, newSize[1]);
        
        int w2 = Math.max(width, newSize[1]);
        int h2 = Math.max(height, newSize[0]);
        
        if ((w1 * h1) < (w2 * h2)) {
            oldSize[0] = w1;
            oldSize[1] = h1;
        } else {
            oldSize[0] = w2;
            oldSize[1] = h2;
        }
    }
}