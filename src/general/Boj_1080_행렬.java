package general;

import java.io.*;
import java.util.*;

public class Boj_1080_행렬 {
    static int n, m;
    static char[][] input, output;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new char[n][m];
        output = new char[n][m];
        for(int i =0; i <n; i++){
            input[i] = br.readLine().toCharArray();
        }
        for(int i =0; i <n; i++){
            output[i] = br.readLine().toCharArray();
        }
        for(int i =0; i < n-2; i++){
            for(int j = 0; j < m-2; j++){
                if(input[i][j] != output[i][j]) go(i, j);
            }
        }
        for(int i = 0; i <n; i++){
            for(int j = 0 ; j < m; j++){
                if(input[i][j] != output[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(cnt);
    }
    static void go(int x,int y){
        for(int i =x; i<=x+2; i++){
            for(int j = y; j<=y+2; j++){
                if(input[i][j] == '1') input[i][j]= '0';
                else input[i][j] = '1';
            }
        }
        cnt++;
    }
}
