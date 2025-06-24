class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; 
        int currentPosition = 1; 
        int stationIdx = 0; 

        while (currentPosition <= n) {
            if (stationIdx < stations.length && currentPosition >= stations[stationIdx] - w) {
                currentPosition = stations[stationIdx] + w + 1;
                stationIdx++; 
            } else {
                answer++;
                currentPosition += (2 * w + 1);
            }
        }

        return answer;
    }
}