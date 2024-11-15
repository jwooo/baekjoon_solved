import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int time = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < time; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double num = Double.parseDouble(st.nextToken());
			
			while (st.hasMoreTokens()) {
				String operator = st.nextToken();
				
				if (operator.equals("@")) {
					num *= 3;
				} else if (operator.equals("%")) {
					num += 5;
				} else if (operator.equals("#")) {
					num -= 7;
				}
			}
			
			System.out.printf("%.2f\n", num);
		}
	}
}