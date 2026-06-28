class Solution {
    public int[] solution(String[] wallpaper) {
        int startY = wallpaper.length;
        int startX = wallpaper[0].length();
        
        int endY = 0;
        int endX = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char now = wallpaper[i].charAt(j);
                
                if (now == '#') {
                    startY = Math.min(startY, i);
                    startX = Math.min(startX, j);
                    
                    endY = Math.max(endY, i + 1);
                    endX = Math.max(endX, j + 1);
                }
            }
        }
        
        return new int[] {startY, startX, endY, endX};
    }
}