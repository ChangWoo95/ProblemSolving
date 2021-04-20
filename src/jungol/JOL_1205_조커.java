package jungol;

import java.io.*;
import java.util.*;

// 투 포인터
public class JOL_1205_조커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] list = new boolean[1001002];

        int max = 0;
        int zeroCnt = 0;
        int answer = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n; ++i){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) ++zeroCnt;
            list[x] = true;
            max = Integer.max(x, max);
        }
        int left = 1, right = 1;
        int joker = zeroCnt;

        while(right <= max + zeroCnt && left <= max){
            if(list[right]) ++right;
            else {
                if(joker > 0) {
                    ++right;
                    --joker;
                } else {
                    if(!list[left]) ++joker;
                    ++left;
                }
            }
            answer = Math.max(answer, right - left);
        }
        if(zeroCnt == n) answer = n;
        System.out.println(answer);
    }
}
