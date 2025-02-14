import java.util.*;

class Solution {
    
    private static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        generateNumbers("", numbers, visited);
        
        return primes.size();
    }
    
    private void generateNumbers(String now, String numbers, boolean[] visited) {
        if (!now.equals("")) {
            int num = Integer.parseInt(now);
            if (isPrime(num)) primes.add(num);
        }
        
        if (now.length() == numbers.length()) return;
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(now + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
 
}