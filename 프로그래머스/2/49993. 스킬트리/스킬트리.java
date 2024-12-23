import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String now = skill_trees[i];
            
            for (int j = 0; j < skill.length(); j++) {
                queue.offer(skill.charAt(j));
            }
            
            for (int j = 0; j < now.length(); j++) {
                Character nowSkill = now.charAt(j);
                
                if (set.contains(nowSkill)) {
                    Character needSkill = queue.poll();
                    
                    if (!nowSkill.equals(needSkill)) {
                        answer -= 1;
                        break;
                    }
                }
            }
            
            queue.clear();
        }
        
        return answer;
    }
}