package general;

import java.io.*;
import java.util.*;

public class Boj_16926_배열돌리기1 {
    static int n, m, cnt;
    static int[][] list;
    static int[][] d = { {0, 1} , {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); cnt = Integer.parseInt(st.nextToken());
        list = new int[n][m];

        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                list[i][j] = Integer.parseInt(st.nextToken());
        }
        spin();
        for(int i =0; i <n; i++){
            for(int j = 0; j <m; j++)
                sb.append(list[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void spin(){
        int val = Math.min(n, m) / 2;
        for(int i =0; i <cnt; i++){
            for(int j=0;j<val; j++){
                int x = j, y = j;
                int value = list[x][y];
                int idx = 0;
                while(idx < 4) {
                    int nx = x + d[idx][0];
                    int ny = y + d[idx][1];
                    if(nx >= j && ny >= j && nx < n- j && ny < m-j){
                        list[x][y] = list[nx][ny];
                        x = nx;
                        y = ny;
                    }
                    else idx++;
                }
                list[j+1][j] = value;
            }
        }
    }
}
