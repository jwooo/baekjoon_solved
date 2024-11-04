import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] num = new int[5];
        int sum = 0;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        
        Arrays.sort(num);
        System.out.println((int)(sum / 5));
        System.out.println(num[2]);
    }
}