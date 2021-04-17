package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_파리퇴치 {
    static int n, m;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t<= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for(int i =0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j <n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i =0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    max = Math.max(max, kill(i, j));
                }
            }
            sb.append("#" + t + " ").append(max).append("\n");
            max = Integer.MIN_VALUE;
        }
        System.out.print(sb);
    }
    static int kill(int x,int y){
        int sum = 0;
        for(int i = 0; i< m; i++){
            for(int j=0;j< m;j++){
                if(!isIn(x+i, y+j)) return 0;
                sum+= map[x+i][y+j];
            }
        }
        return sum;
    }
    static boolean isIn(int nx, int ny) {
        return nx >= 0 && nx < n && ny >=0 && ny < n;
    }
}
