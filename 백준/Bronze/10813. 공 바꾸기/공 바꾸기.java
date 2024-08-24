import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strtk = new StringTokenizer(br.readLine()," ");
		
		int basket = Integer.parseInt(strtk.nextToken());
		int count = Integer.parseInt(strtk.nextToken()); 
		
		int n1, n2, temp = 0;
		
		int array1[] = new int[basket];
		
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }

        for (int i = 0; i < count; i++) {
			strtk = new StringTokenizer(br.readLine()," ");
			n1 = Integer.parseInt(strtk.nextToken())-1;
			n2 = Integer.parseInt(strtk.nextToken())-1;
			
			temp = array1[n1];
			array1[n1] = array1[n2];
			array1[n2] = temp;
        }
		
		
		br.close();
		
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
		
	}

}
