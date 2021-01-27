package graph;

import java.io.*;
import java.util.*;

public class Boj_1103_게임 {
    static int[][] deltas = { {0,1}, {0,-1}, {1,0}, {-1,0} }; // 상하좌우 좌표
    static String[] map; // 현재 map
    static int[][] dp; // 이동하는 칸을 담기위한 dp배열(메모이제이션 이용함)
    static boolean[][] checked; // 방문을 위한 배열
    static int r,c;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dp = new int[r][c];
        checked = new boolean[r][c];
        map = new String[r];

        for(int i =0; i< r; i++) {
            map[i] = br.readLine();
        }

        ans = findMax(0, 0);
        System.out.print(ans);
    }

    static int findMax(int x, int y) {
        if(!isIn(x, y)) return 0; // 좌표가 map을 벗어나면 
        if(map[x].charAt(y) == 'H') return 0; // 함정에 걸린다면
        if(checked[x][y]) { // 예전에 방문을 한 곳이라면, 무한루프가 돌 수 있는 구조이므로 조건에 따라 -1 반환
            System.out.print(-1);
            System.exit(0);
        }
        if(dp[x][y] != 0) return dp[x][y]; // dp값이 0이 아니라면(이미 예전에 방문했던 곳이면) 가지치기를 해줌
        checked[x][y] = true;
        for (int i = 0; i < 4; i++)
            dp[x][y] = Math.max(dp[x][y], findMax(x + ((map[x].charAt(y)-'0') * deltas[i][0]), y + ((map[x].charAt(y)-'0') * deltas[i][1]) ) + 1);
        checked[x][y] = false;
        return dp[x][y];
    }

    static boolean isIn(int x, int y) {
        if(x < 0 || x >= r || y <0 || y >= c) return false;
        return true;
    }

}
