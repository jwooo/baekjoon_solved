import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
        
        Arrays.sort(files, (x, y) -> {
           	Matcher m1 = p.matcher(x.toLowerCase());
            Matcher m2 = p.matcher(y.toLowerCase());
            
            m1.find();
            m2.find();
            
            if (!m1.group(1).equals(m2.group(1))) return m1.group(1).compareTo(m2.group(1));
            else return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
        });
        
        return files;
    }
}