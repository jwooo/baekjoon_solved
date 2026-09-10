import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long totalTime = 0;

        for (int foodTime : food_times) {
            totalTime += foodTime;
        }

        if (totalTime <= k) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new int[]{food_times[i], i + 1});
        }

        long elapsed = 0;
        long previousTime = 0;
        int remaining = food_times.length;

        while (!pq.isEmpty()) {
            int currentTime = pq.peek()[0];
            long requiredTime = (long) (currentTime - previousTime) * remaining;

            if (elapsed + requiredTime > k) {
                break;
            }

            elapsed += requiredTime;
            previousTime = currentTime;

            while (!pq.isEmpty() && pq.peek()[0] == currentTime) {
                pq.poll();
                remaining--;
            }
        }

        List<int[]> foods = new ArrayList<>(pq);
        foods.sort((a, b) -> Integer.compare(a[1], b[1]));
        int index = (int) ((k - elapsed) % remaining);

        return foods.get(index)[1];
    }
}