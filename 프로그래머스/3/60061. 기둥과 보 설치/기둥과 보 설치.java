import java.util.*;

class Solution {
    static boolean[][] pillars; // 기둥 설치 여부
    static boolean[][] beams;   // 보 설치 여부
    static int N; // 전체 벽면 크기

    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        pillars = new boolean[n + 1][n + 1];
        beams = new boolean[n + 1][n + 1];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3]; 

            if (b == 1) { 
                if (a == 0) { 
                    if (canBuildPillar(x, y)) {
                        pillars[x][y] = true;
                    }
                } else { 
                    if (canBuildBeam(x, y)) {
                        beams[x][y] = true;
                    }
                }
            } else { 
                if (a == 0) {
                    pillars[x][y] = false;
                    if (!isValid()) { 
                        pillars[x][y] = true;
                    }
                } else {
                    beams[x][y] = false;
                    if (!isValid()) { 
                        beams[x][y] = true;
                    }
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j]) {
                    result.add(new int[]{i, j, 0});
                }
                if (beams[i][j]) {
                    result.add(new int[]{i, j, 1});
                }
            }
        }

        Collections.sort(result, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });

        return result.toArray(new int[result.size()][]);
    }

    boolean canBuildPillar(int x, int y) {
        if (y == 0) return true;
        if (x > 0 && beams[x - 1][y]) return true; 
        if (beams[x][y]) return true; 
        if (y > 0 && pillars[x][y - 1]) return true;
        return false;
    }

    boolean canBuildBeam(int x, int y) {
        if (y > 0 && pillars[x][y - 1]) return true; 
        if (y > 0 && x + 1 <= N && pillars[x + 1][y - 1]) return true;

        if (x > 0 && x + 1 <= N && beams[x - 1][y] && beams[x + 1][y]) return true;
        return false;
    }

    boolean isValid() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (pillars[i][j]) {
                    if (!canBuildPillar(i, j)) {
                        return false;
                    }
                }
                
                if (beams[i][j]) {
                    if (!canBuildBeam(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}