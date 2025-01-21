import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;

        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCount = new HashMap<>();

        while (end < gems.length) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            end++;

            while (gemCount.size() == gemTypes.size()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }
        }

        return answer;
    }
}
