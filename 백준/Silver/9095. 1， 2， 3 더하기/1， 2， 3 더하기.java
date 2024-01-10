

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[12];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j < arr.length; j++) {
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            
            System.out.println(arr[n]);
        }
    }
}