class Solution {
    public int solution(int storey) {
        return dfs(storey, 0);
    }
    
    private int dfs(int n, int count) {
        if (n < 10) {
            if (n < 6) return count + n;
            else return count + (10 - n) + 1;
        }
        
        return Math.min(dfs(n / 10, count + (n % 10)),
                       dfs(n / 10 + 1, count + (10 - n % 10)));
    }
}