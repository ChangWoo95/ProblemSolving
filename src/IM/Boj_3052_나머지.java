package IM;

import java.io.*;
import java.util.*;

public class Boj_3052_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxVal = -1;
        int x, cnt = 0;
        int[] list = new int[43];
        String s;
        while( (s = br.readLine())!= null && s.length() != 0 ) {
            x = Integer.parseInt(s) % 42;
            maxVal = Math.max(maxVal, x);
            list[x]++;
        }
        for(int i = 0 ; i <= maxVal; i++){
            if(list[i] != 0) cnt++;
        }
        System.out.println(cnt);
    }
}
