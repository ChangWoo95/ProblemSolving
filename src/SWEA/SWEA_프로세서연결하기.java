package SWEA;

import java.awt.*;
import java.io.*;
import java.util.*;

public class SWEA_프로세서연결하기 {
    static int n;
    static int[][] map;
    static int[][] d = { {-1, 0 }, {0, 1} , {1, 0}, {0, -1} };
    static ArrayList<int[]> core;
    static boolean[][] visited;
    static int maxCore = Integer.MIN_VALUE;
    static int minLine = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; ++t){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            core = new ArrayList<>();
            for(int i = 0 ; i <n; ++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < n; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i == 0 || i == n-1 || j == 0 || j == n-1 || map[i][j] != 1) continue;
                    core.add(new int[] { i, j});
                }
            }
            dfs(0, 0, 0);
            sb.append("#" + t + " ").append(minLine).append("\n");
            maxCore = Integer.MIN_VALUE;
            minLine = Integer.MAX_VALUE;
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int coreCnt, int lineCnt ){
        if(depth == core.size()){
            if(maxCore < coreCnt){
                maxCore = coreCnt;
                minLine = lineCnt;
            } else if(maxCore == coreCnt){
                minLine = Integer.min(minLine, lineCnt);
            }
            return;
        }
        dfs(depth + 1, coreCnt, lineCnt );

        for(int i = 0; i < 4; ++i){
            if(check(depth, i) ) {
                int line = connect(depth, i);
                dfs(depth + 1, coreCnt + 1, lineCnt + line);
                disconnect(depth, i);
            }
        }
    }

    static void disconnect(int depth, int i){ // 연결해제
        int x = core.get(depth)[0];
        int y = core.get(depth)[1];
        while(true){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) return ;
            map[nx][ny] = 0;
            x = nx;
            y = ny;
        }
    }

    static int connect(int depth, int i){ // 연결
        int x = core.get(depth)[0];
        int y = core.get(depth)[1];
        int cnt = 0;
        while(true){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            map[nx][ny] = -1;
            x = nx;
            y = ny;
            ++cnt;
        }
        return cnt;
    }

    static boolean check(int depth, int i){ //연결 가능한지 확인
        int x = core.get(depth)[0];
        int y = core.get(depth)[1];
        while(true){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) return true;
            if(map[nx][ny] == 1 || map[nx][ny] == -1) return false;
            x = nx;
            y = ny;
        }
    }
}
