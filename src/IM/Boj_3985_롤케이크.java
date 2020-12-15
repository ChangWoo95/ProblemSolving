package IM;

import java.io.*;
import java.util.*;

public class Boj_3985_롤케이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        boolean[] cake = new boolean[n+1];
        int maxCnt = Integer.MIN_VALUE, maxIdx = Integer.MAX_VALUE;
        int realMax = Integer.MIN_VALUE, realIdx = Integer.MIN_VALUE;
        for(int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            if(i2 - i1 + 1 > maxCnt){
                maxIdx = i;
                maxCnt = i2 - i1 + 1;
            }
            int tmp = 0;
            for(int j = i1; j <= i2; j++){
                if(!cake[j]){
                    cake[j] = true;
                    tmp++;
                }
            }
            if(realMax < tmp){
                realMax = tmp;
                realIdx = i;
            }
        }
        sb.append(maxIdx).append("\n").append(realIdx);
        System.out.print(sb);
    }
}
