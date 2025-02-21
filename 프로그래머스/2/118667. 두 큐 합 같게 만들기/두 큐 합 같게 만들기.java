import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sumA = 0;
        long sumB = 0;
        
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB =new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            sumA += queue1[i];
            sumB += queue2[i];
            
            queueA.add(queue1[i]);
            queueB.add(queue2[i]);
        }
        
        if (sumA == sumB) return 0;
        answer = func(queueA, queueB, sumA, sumB);
     
        return answer;
    }
    
    private int func(Deque<Integer> queueA, Deque<Integer> queueB, long sumA, long sumB) {
        int count = 0;
        long target = (sumA + sumB) / 2;
        int length = queueA.size() * 3;
        int index = 0;
        
        while (index < length) {
            index++;
            
            if (sumA > sumB) {
                int value = queueA.poll();
                queueB.add(value);
                sumA -= value;
                sumB += value;
                count++;
            } else if (sumA < sumB) {
                int value = queueB.poll();
                queueA.add(value);
                sumA += value;
                sumB -= value;
                count++;
            } else return count;
        }
        
        return -1;
    }
}