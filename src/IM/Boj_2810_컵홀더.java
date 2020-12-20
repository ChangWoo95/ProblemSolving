package IM;

import java.io.*;
import java.util.*;

public class Boj_2810_컵홀더 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1; int lCnt = 0;
        String s = br.readLine();
        char cur = 0;
        for(int i = 0 ; i < n; i++){
            cur = s.charAt(i);
            if(cur == 'S'){
                cnt++;

            } else {
                ++lCnt;
                if(lCnt == 2) {
                    lCnt = 0;
                    ++cnt;
                }
            }
        }
        if(lCnt == 1) cnt++;

        System.out.println(Math.min(cnt, n));
    }
}
