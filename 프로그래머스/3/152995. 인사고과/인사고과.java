import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoWork = scores[0][0];
        int wanhoPeer = scores[0][1];
        int wanhoSum = wanhoWork + wanhoPeer;

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];     
            return b[0] - a[0];          
        });

        int answer = 1;
        int maxPeer = 0;

        for (int[] s : scores) {

            if (s[1] < maxPeer) {
                if (s[0] == wanhoWork && s[1] == wanhoPeer)
                    return -1;

                continue;
            }

            maxPeer = Math.max(maxPeer, s[1]);

            if (s[0] + s[1] > wanhoSum)
                answer++;
        }

        return answer;
    }
}