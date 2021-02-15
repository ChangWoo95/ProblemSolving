package backtracking;

import java.io.*;
import java.util.*;

public class Boj_2961_도영이가만든맛있는음식 {
    static int n;
    static int[][] list;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new int[n][2];
        for(int i = 0 ; i <n; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++)
            comb(0, 0, 1, 0, i);

        System.out.println(ans);
    }
    static void comb(int depth, int start, int x, int y, int idx){
        if(depth == idx+1){
            ans = Math.min(ans, Math.abs(x - y));
            return;
        }
        for(int i = start; i  < n; i++)
            comb(depth + 1, i+1, x * list[i][0], y + list[i][1], idx);
    }
}
