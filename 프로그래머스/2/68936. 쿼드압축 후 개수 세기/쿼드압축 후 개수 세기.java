import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        Compressor compressCount = getCompressCount(0, 0, arr.length, arr);
        
        answer[0] = compressCount.zero;
        answer[1] = compressCount.one;
        
        return answer;
    }
    
    private Compressor getCompressCount(int x, int y, int size, int[][] arr) {
        if (isUniform(x, y, size, arr)) return Compressor.of(arr[y][x]);
        
        int nextSize = size / 2;
        
        Compressor now = getCompressCount(x, y, nextSize, arr);
        Compressor nowX = getCompressCount(x + nextSize, y, nextSize, arr);
        Compressor nowY = getCompressCount(x, y + nextSize, nextSize, arr);
        Compressor nowXY = getCompressCount(x + nextSize, y + nextSize, nextSize, arr);
        
        return new Compressor(
            now.zero + nowX.zero + nowY.zero + nowXY.zero,
            now.one + nowX.one + nowY.one + nowXY.one
        );
    }
    
    private boolean isUniform(int x, int y, int size, int[][] arr) {
        int now = arr[y][x];
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (now != arr[i][j]) return false;
            }
        }
        
        return true;
    }
    
    static class Compressor {
        int zero;
        int one;
        
        public Compressor(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public static Compressor of(int number) {
            if (number == 0) return new Compressor(1, 0);
            else return new Compressor(0, 1);
        }
    }
}