package general;

import java.io.*;
import java.util.*;

public class Boj_11050_이항계수1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 1;

        for(int i = n; i > n - k; i--){
            result *= i;
        }
        for(int i = 2; i<=k; i++){
            result /= i;
        }
        System.out.println(result);
    }
}
