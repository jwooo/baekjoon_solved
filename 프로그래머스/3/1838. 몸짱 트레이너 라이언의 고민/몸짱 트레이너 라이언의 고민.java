import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int[] times = new int[1322];

        for (int[] t : timetable) {
            times[t[0]]++;
            times[t[1] + 1]--;
        }

        int current = 0;
        int maxPeople = 0;

        for (int i = 600; i <= 1320; i++) {
            current += times[i];
            maxPeople = Math.max(maxPeople, current);
        }

        if (maxPeople <= 1) {
            return 0;
        }

        for (int distance = 2 * (n - 1); distance >= 1; distance--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    List<int[]> lockers = new ArrayList<>();
                    lockers.add(new int[]{i, j});

                    for (int y = i; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            if (y == i && x <= j) {
                                continue;
                            }

                            int[] candidate = {y, x};

                            if (canPlace(candidate, distance, lockers)) {
                                lockers.add(candidate);

                                if (lockers.size() == maxPeople) {
                                    return distance;
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private boolean canPlace(int[] candidate, int distance, List<int[]> lockers) {
        for (int[] locker : lockers) {
            int dist = Math.abs(candidate[0] - locker[0])
                    + Math.abs(candidate[1] - locker[1]);

            if (dist < distance) {
                return false;
            }
        }

        return true;
    }
}