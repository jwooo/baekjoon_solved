import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int numCores = cores.length;
        long low = 0;
        long high = (long) n * 10000; 

        long minProcessingTime = high; // N번째 작업이 할당되는 최소 시간을 저장할 변수

        // 이분 탐색 시작
        while (low <= high) {
            long mid = low + (high - low) / 2;

            // mid 시간까지 처리 가능한 총 작업 수 계산
            // 초기 numCores개의 작업은 0초에 각 코어에 할당됩니다.
            long tasksProcessedCount = numCores; 
            for (int coreTime : cores) {
                // 각 코어는 mid 시간 동안 (mid / coreTime)개의 추가 작업을 처리할 수 있습니다.
                tasksProcessedCount += mid / coreTime;
            }

            if (tasksProcessedCount >= n) {
                // mid 시간까지 N개 이상의 작업을 처리할 수 있다면,
                // mid가 정답일 수 있으므로 저장하고, 더 짧은 시간을 찾아봅니다.
                minProcessingTime = mid;
                high = mid - 1;
            } else {
                // mid 시간까지 N개 미만의 작업을 처리했다면, 
                // 시간이 부족하므로 시간을 더 늘려야 합니다.
                low = mid + 1;
            }
        }

        // minProcessingTime은 N번째 작업이 할당되는 최초 시간입니다.
        // 이제 이 시간까지 정확히 N번째 작업이 어떤 코어에 할당되는지 찾아야 합니다.

        // minProcessingTime - 1 시간까지 처리된 총 작업 수 계산
        long tasksProcessedBeforeMinTime = numCores; // 0초에 할당된 코어 수
        for (int coreTime : cores) {
            tasksProcessedBeforeMinTime += (minProcessingTime - 1) / coreTime;
        }

        // minProcessingTime 시점에 작업을 처리할 수 있는 코어들을 인덱스 순으로 탐색
        for (int i = 0; i < numCores; i++) {
            // 해당 코어가 minProcessingTime에 작업을 처리할 수 있는지 확인 (즉, minProcessingTime에 작업이 끝나는지)
            if (minProcessingTime % cores[i] == 0) {
                tasksProcessedBeforeMinTime++; // 이 코어가 처리하는 작업 추가
                if (tasksProcessedBeforeMinTime == n) {
                    // 현재 코어가 처리하는 작업이 정확히 N번째 작업이라면
                    return i + 1; // 해당 코어의 번호 반환 (인덱스 + 1)
                }
            }
        }

        // 여기까지 코드가 도달하면 문제가 발생한 경우 (모든 경우의 수를 처리했어야 함)
        return -1; 
    }
}