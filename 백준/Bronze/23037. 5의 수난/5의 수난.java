import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ch = br.readLine();

        int[] num = new int[ch.length()];

        int sum = 0;

        for(int i=0;i<ch.length();i++){
            num[i] = ch.charAt(i)-'0';
        }

        for(int i=0;i<num.length;i++){
            sum+=Math.pow(num[i],5);
        }

        System.out.println(sum);
    }
}