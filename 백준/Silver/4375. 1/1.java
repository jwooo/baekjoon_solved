import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input.trim());
            long num = 1; 
            int digits = 1;

            while (true) {
                if (num % n == 0) {
                    System.out.println(digits);
                    break;
                }
                
                num = (num * 10 + 1) % n;
                digits++;
            }
        }
    }
}