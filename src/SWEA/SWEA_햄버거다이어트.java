package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_햄버거다이어트 {
    static int n, l;
    static int[] cal, taste;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t <=T; t++) {
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            cal = new int[n];
            taste = new int[n];
            for(int i =0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0, 0);
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.print(sb);
    }
    static void comb(int kal, int start,int t){
        if(t!=0 && kal <= l){
            max = Math.max(max, t);
        }
        if(start == n) return;
        for(int i =start; i < n; i++){
            if(kal + cal[i] > l) continue;
            comb(kal + cal[i], i + 1, t + taste[i]);
        }
    }
}
