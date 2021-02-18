package IM;

import java.io.*;
import java.util.*;

public class 빵집 {
    static int r, c, cnt = 0;
    static char[][] map;
    static int[][] d = { {-1,1}, {0,1}, {1,1} };
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][];

        for(int i=0; i <r; i++)
            map[i] = br.readLine().toCharArray();

        for(int i = 0; i < r; i++){
            dfs(i, 0);
            flag = false;
        }
        System.out.println(cnt);
    }
    static void dfs(int x,int y){
        if( y == c-1 ) {
            ++cnt;
            flag = true;
            return;
        }
        for(int i = 0; i < 3; i++){
            if(isIn(x+d[i][0], y+d[i][1]) && map[x+d[i][0]][y+d[i][1]] == '.' ) {
                map[x+d[i][0]][y+d[i][1]] = 'x';
                dfs(x+d[i][0], y+d[i][1]);
                if(flag) return; //라인 완성된다면 더 돌지 말아야함
            }
        }
    }
    static boolean isIn(int x,int y){
        return x>=0 && x < r && y>=0 && y<c;
    }
}
