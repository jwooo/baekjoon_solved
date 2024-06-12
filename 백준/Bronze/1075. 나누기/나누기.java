import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        
        n -= (n%100);
        
        while (true) {
            if (n % f == 0) {
                break;
            }
            n++;
        }
        
        System.out.format("%02d", (n % 100));
    }
}