class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int horizontal = n - 1;
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            horizontal = Math.min(horizontal, i + n - next + Math.min(i, n - next));
        }
        
        return answer + horizontal;
    }
}