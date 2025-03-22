import java.util.*;

class Solution {
    
    static Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < info.length; i++) {
            String[] nowInfo = info[i].split(" ");
            dfs(0, "", nowInfo);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] nowQuery = query[i].split(" ");
            
            String key = nowQuery[0] + nowQuery[2] + nowQuery[4] + nowQuery[6];
            int value = Integer.parseInt(nowQuery[nowQuery.length - 1]);
            
            answer[i] = map.containsKey(key) ? binarySearch(key, value) : 0;
        }
        
        return answer;
    }
    
    public void dfs(int depth, String now, String[] info) {
        if (depth == 4) {
            if (!map.containsKey(now)) {
                map.put(now, new ArrayList<>());
            }
            map.get(now).add(Integer.valueOf(info[4]));
            return;
        }
        
        dfs(depth + 1, now + info[depth], info);
        dfs(depth + 1, now + "-", info);
    }
    
    public int binarySearch(String key, int value) {
        List<Integer> list = map.get(key);
        
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (list.get(mid) >= value) end = mid;
            else start = mid + 1;
        }
        
        return list.size() - start;
    }
}