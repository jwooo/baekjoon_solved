class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        String now = sb.reverse().toString();
        for (int i = 0; i < now.length(); i++) {
            answer += Math.pow(3, i) * (now.charAt(i) - '0');
        }
        
        return answer;
    }
}