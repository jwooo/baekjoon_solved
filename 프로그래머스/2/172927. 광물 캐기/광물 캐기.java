import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int groupCount = Math.min((minerals.length + 4) / 5, totalPicks);
        
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for (int j = i * 5; j < Math.min((i + 1) * 5, minerals.length); j++) {
                String mineral = minerals[j];
                
                if (mineral.equals("diamond")) diamond++;
                else if (mineral.equals("iron")) iron++;
                else stone++;
            }
            
            groups.add(new int[] {diamond, iron, stone});
        }
        
        groups.sort((a, b) -> {
            int tiredA = a[0] * 25 + a[1] * 5 + a[2] * 1;
            int tiredB = b[0] * 25 + b[1] * 5 + b[2] * 1;
            
            return tiredB - tiredA;
        });
        
        for (int[] group : groups) {
            System.out.println(Arrays.toString(group));
        }
        
        int answer = 0;
        for (int[] group : groups) {
            if (picks[0] > 0) {
                answer += group[0] + group[1] + group[2];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += group[0] * 5 + group[1] + group[2];
                picks[1]--;
            } else {
                answer += group[0] * 25 + group[1] * 5 + group[2];
                picks[2]--;
            }
            System.out.println(answer);
        }
        
        return answer;
    }
}