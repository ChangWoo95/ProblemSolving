package bfsdfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_2842_집배원한상덕 {
    static int n, kCnt, cnt = 0;
    static int[][] wei;
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = { {-1, 0}, {-1, 1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1} };
    static Point p = new Point(0,0);
    static int minCnt = Integer.MAX_VALUE;
    static TreeSet<Integer> ts = new TreeSet<>();
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n][];
        wei = new int[n][n];
        visited = new boolean[n][n];
        for(int i =0; i<n; ++i) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0 ; j <n; ++j){
                if(map[i][j] == 'P') {p.x = i; p.y = j;}
                else if(map[i][j] == 'K') ++kCnt;
            }
        }

        for(int i = 0 ; i <n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <n; j++){
                wei[i][j] = Integer.parseInt(st.nextToken());
                ts.add(wei[i][j]);
            }
        }
        list = new int[ts.size()];
        Iterator<Integer> it = ts.iterator();
        for(int i = 0 ; i <ts.size(); i++)
            list[i] = it.next();
        int l = 0, r = 0;

        while(l <= r && r < list.length){
            if(wei[p.x][p.y] >= list[l] && wei[p.x][p.y] <= list[r]) dfs(p.x, p.y, l, r);
            if(cnt == kCnt) {minCnt = Integer.min(minCnt, list[r] - list[l]); ++l; }
            else ++r;
            cnt = 0;
            for(int i = 0 ; i <n; i++) Arrays.fill(visited[i], false);
        }
        System.out.println(minCnt);
    }
    static void dfs(int x, int y, int l, int r){
        if( x< 0 || x >=n || y <0 || y>=n || visited[x][y] || wei[x][y] < list[l] || wei[x][y] > list[r]) return;
        visited[x][y] = true;
        if(map[x][y] == 'K') ++cnt;
        for(int i = 0 ; i <8; ++i){
            dfs(x + d[i][0], y + d[i][1], l, r);
        }
    }

}
