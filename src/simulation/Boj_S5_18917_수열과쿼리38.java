package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_S5_18917_수열과쿼리38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0 ;
        long xor = 0;

        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if(order == 1){
                long num = Integer.parseInt(st.nextToken());
                sum += num;
                xor ^= num;
            }
            else if(order == 2) {
                long num = Integer.parseInt(st.nextToken());
                sum -= num;
                xor ^= num;
            }
            else if(order == 3) {
                System.out.println(sum);
            } else {
                System.out.println(xor);
            }
        }

    }
}
