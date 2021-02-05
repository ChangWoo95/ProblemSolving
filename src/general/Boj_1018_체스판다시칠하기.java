package general;

import java.io.*;
import java.util.*;

public class Boj_1018_체스판다시칠하기 {
    static int n, m;
    static char[][] map;
    static int ans = Integer.MAX_VALUE;
    static String[] chess = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW" , "WBWBWBWB","BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();
        for(int i =0;i < n-7; i++){
            for(int j = 0; j< m-7; j++){
                reColor(i, j, 0);
                reColor(i, j, 1);
            }
        }
        System.out.println(ans);
    }
    static void reColor(int x,int y, int flag){
        int sum = 0, cx = 0, cy = 0;

        for(int  i =x; i < x+ 8; i++){
            for(int j = y; j < y+ 8; j++){
                if(flag == 1) {
                    if (map[i][j] != chess[cx].charAt(cy++)) sum++;
                } else {
                    if (map[i][j] == chess[cx].charAt(cy++)) sum++;
                }
            }
            cx++;
            cy = 0;
        }
        ans = Math.min(ans, sum);
    }
}
