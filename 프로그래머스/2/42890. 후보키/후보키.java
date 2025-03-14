import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();
        
        for (int bitmask = 1; bitmask < (1 << col); bitmask++) {
            if (!isUnique(bitmask, row, col, relation)) continue;
            if (isMinimum(bitmask, candidateKeys)) candidateKeys.add(bitmask);
        }
        
        return candidateKeys.size();
    }
    
    private boolean isUnique(int bitmask, int row, int col, String[][] relation) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if ((bitmask & (1 << j)) != 0) sb.append(relation[i][j]).append("|");
            }
            set.add(sb.toString());
        }
        
        return set.size() == row;
    }
    
    private boolean isMinimum(int bitmask, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((key & bitmask) == key) return false;
        }
        
        return true;
    }
}