class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        int newLockSize = n + 2 * (m - 1);
        int[][] newLock = new int[newLockSize][newLockSize];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }
        
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);
            
            for (int r = 0; r < newLockSize - m + 1; r++) {
                for (int c = 0; c < newLockSize - m + 1; c++) {
                    int[][] tempLock = new int[newLockSize][newLockSize];
                    for (int i = 0; i < newLockSize; i++) {
                        for (int j = 0; j < newLockSize; j++) {
                            tempLock[i][j] = newLock[i][j];
                        }
                    }
                    
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            tempLock[r + i][c + j] += key[i][j];
                        }
                    }
                    
                    if (check(tempLock, n, m)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotateKey = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotateKey[j][m - 1 - i] = key[i][j];
            }
        }
        
        return rotateKey;
    }
    
    public boolean check(int[][] newLock, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newLock[i + m -1][j + m - 1] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}