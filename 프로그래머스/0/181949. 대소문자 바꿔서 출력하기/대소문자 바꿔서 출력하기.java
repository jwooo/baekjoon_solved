import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char now = a.charAt(i);
            
            if (now >= 'a' && now <= 'z') {
                sb.append(String.valueOf(now).toUpperCase());
            } else {
                sb.append(String.valueOf(now).toLowerCase());
            }
        }
        
        System.out.println(sb.toString());
    }
}