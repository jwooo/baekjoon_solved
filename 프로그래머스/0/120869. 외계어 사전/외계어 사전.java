class Solution {
    public int solution(String[] spell, String[] dic) {
        for (int i = 0; i < dic.length; i++) {
            String now = dic[i];
            
            if (now.length() == spell.length) {
                int count = spell.length;
                for (int j = 0; j < spell.length; j++) {
                    if (now.contains(spell[j])) count--;
                }
                
                if (count == 0) return 1;
            }
        }
        
        return 2;
    }
}