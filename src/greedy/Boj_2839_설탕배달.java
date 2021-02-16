package greedy;

import java.io.*;
import java.util.*;

public class Boj_2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n > 0){
            if(n % 5 == 0){
                n -=5;
                ++cnt;
            }
            else if(n % 3 == 0){
                n -=3;
                ++cnt;
            }
            else if( n > 5){
                n -=5;
                ++cnt;
            }
            else{
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);

    }
}
