import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int n = 1;
        while (n <= Math.max(arrayA[0], arrayB[0])) {
            if (arrayA[0] % n == 0 && arrayB[0] % n == 0) {
                n++;
                continue;
            }
            
            int size = 0;
            boolean isDivideA = arrayA[0] % n == 0 ? true : false;
            for (int i = 0; i < arrayA.length; i++) {
                if (isDivideA) {
                    if (arrayA[i] % n == 0 && arrayB[i] % n != 0) size++;
                    else break;
                } else {
                    if (arrayA[i] % n != 0 && arrayB[i] % n == 0) size++;
                    else break;
                }
            }
            
            if (size == arrayA.length) answer = Math.max(n, answer);
            n++;
        }
        
        return answer;
    }
}