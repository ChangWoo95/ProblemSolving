package IM;

import java.io.*;
import java.util.*;

public class Boj_2116_주사위쌓기 {
    static int n, ans = Integer.MIN_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][6];
        for(int i = 0 ; i <  n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j  <3; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
            map[i][4] = Integer.parseInt(st.nextToken());
            map[i][5] = Integer.parseInt(st.nextToken());
            map[i][3] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < 6; i++){
            dfs(0, map[0][i], 0);
        }
        System.out.println(ans);
    }
    static void dfs(int depth, int val, int maxVal){
        if(depth == n) {
            ans = Math.max(ans, maxVal);
            return;
        }
        for(int i = 0 ; i < 6; i++){
            if(map[depth][i] != val) continue;
            int tmp = -1;
            for(int j = 0 ; j < 3; j++){
                if(j == i || j + 3 == i) continue;
                tmp = Math.max(tmp, map[depth][j]);
                tmp = Math.max(tmp, map[depth][j+3]);
            }
            dfs(depth+1, map[depth][(i+3)%6], maxVal + tmp);
        }
    }
}
