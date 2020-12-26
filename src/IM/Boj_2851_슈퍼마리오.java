package IM;

import java.io.*;
import java.util.*;

public class Boj_2851_슈퍼마리오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, ans = 0;
        for(int i = 0; i < 10; i++){
            sum += Integer.parseInt(br.readLine());
            if( Math.abs(sum - 100) <= Math.abs(ans - 100)) ans = sum;
        }
        System.out.println(ans);
    }
}
