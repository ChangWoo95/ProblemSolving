package IM;

import java.io.*;
import java.util.*;

public class Boj_1592_영식이와친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] list = new int[n+1];
        int idx = 1;
        int ans = 0;
        while(true){
            list[idx]++;
            if(list[idx] == m) break;
            if(list[idx] % 2 == 1) { // 홀수
                idx += l;
                if(idx > n)  idx -= n;
            } else {
                idx -= l;
                if(idx <= 0) idx += n;
            }
            ans++;
        }
        System.out.println(ans);

    }
}
