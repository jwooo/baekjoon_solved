import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String userSound = br.readLine();
        String doctorSound = br.readLine();
        
        if (userSound.length() >= doctorSound.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}