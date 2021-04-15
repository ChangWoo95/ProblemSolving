package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_9229_한빈이와SpotMart {
    static int n, w;
    static int[] list;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i <n; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0, 0);
            sb.append("#" + t + " ");
            if(ans == 0) sb.append(-1).append("\n");
            else sb.append(ans).append("\n");
            ans = 0;
        }
        System.out.print(sb);
    }
    static void comb(int depth, int start, int val){
        if(depth == 2) {
            System.out.println(val);
            ans = Math.max(ans, val);
            return;
        }
        for(int i =start; i < n; i++){
            if(val + list[i] > w) continue;
            comb(depth + 1, i + 1, val + list[i]);
        }
    }
}
