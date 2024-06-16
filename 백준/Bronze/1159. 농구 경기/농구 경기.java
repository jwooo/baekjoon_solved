import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[26];
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String buffer = sc.nextLine();
        for (int i = 0; i < num; i++) {
            String temp = sc.nextLine();
            a[temp.charAt(0) - 'a']++;
        }

        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if(a[i] >= 5){
                System.out.print((char)(i + 'a'));
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("PREDAJA");
        }
    }
}