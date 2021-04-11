package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_1954_달팽이숫자 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int x = 0, y = -1, inver = 1, num = 1;

            while(true) {
                for(int i =0; i< n; i++){
                    y += inver;
                    arr[x][y] = num++;
                }
                if(--n == 0) break;
                for(int i =0; i< n; i++){
                    x += inver;
                    arr[x][y] = num++;
                }
                inver *= -1;
            }
            sb.append("#"+t+"\n");
            for(int i =0; i< arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
