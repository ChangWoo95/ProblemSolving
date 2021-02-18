package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_1987_알파벳 {
    static int r,c;
    static char[][] map;
    static int maxCnt = Integer.MIN_VALUE;
    static int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][];
        for(int i = 0 ; i <r; i++)
            map[i] = br.readLine().toCharArray();
        System.out.println(dfs(1,0, 0, 1 << map[0][0] - 'A' ));
    }
    static int dfs(int d, int x, int y, int bit){
        if(maxCnt < d) maxCnt = d;

        for(int i = 0; i< 4; i++){
            int nx = x + dir[i][0]; int ny = y + dir[i][1];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c && (bit & (1 << map[nx][ny] - 'A')) <= 0) {
                dfs(d + 1, nx, ny, (bit | (1 << map[nx][ny] - 'A')) );
            }
        }
        return maxCnt;
    }
}
