import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Integer, List<CharacterType>> map = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            map.put(i, new ArrayList<>());
        }
        
        init(map);
        
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            int point = 0;
            
            char findCharacter = ' ';
            
            if (choice < 4) {
                point = 4 - choice;
                findCharacter = survey[i].charAt(0);
            } else if (choice > 4) {
                point = choice - 4;
                findCharacter = survey[i].charAt(1);
            } else {
                continue;
            }
            
            List<CharacterType> characterTypes = findType(findCharacter, map);
            for (CharacterType ct : characterTypes) {
                if (ct.type == findCharacter) {
                    ct.point += point;
                }
            }
        }
       
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            List<CharacterType> characterTypes = map.get(i);
            Collections.sort(characterTypes);
            
            sb.append(characterTypes.get(0).type);
        }
        
        return sb.toString();
    }
    
    private List<CharacterType> findType(char c, Map<Integer, List<CharacterType>> map) {
        if (c == 'R' || c == 'T') {
            return map.get(1);
        } else if (c == 'C' || c == 'F') {
            return map.get(2);
        } else if (c == 'J' || c == 'M') {
            return map.get(3);
        } else {
            return map.get(4);
        }
    }
    
    private void init(Map<Integer, List<CharacterType>> map) {
        List<CharacterType> type1 = map.get(1);
        type1.add(new CharacterType('R', 0));
        type1.add(new CharacterType('T', 0));
        
        List<CharacterType> type2 = map.get(2);
        type2.add(new CharacterType('C', 0));
        type2.add(new CharacterType('F', 0));
        
        List<CharacterType> type3 = map.get(3);
        type3.add(new CharacterType('J', 0));
        type3.add(new CharacterType('M', 0));
        
        List<CharacterType> type4 = map.get(4);
        type4.add(new CharacterType('A', 0));
        type4.add(new CharacterType('N', 0));
    }
    
    static class CharacterType implements Comparable<CharacterType> {
        char type;
        int point;
        
        public CharacterType(char type, int point) {
            this.type = type;
            this.point = point;
        }
        
        @Override
        public int compareTo(CharacterType o) {
            if (this.point == o.point) {
                return Character.compare(this.type, o.type);
            }
            
            return o.point - this.point;
        }
        
        @Override
        public String toString() {
            return "CharacterType={type: " + type + ", point: " + point + "}";
        }
    }
}