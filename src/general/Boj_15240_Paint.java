package general;

import java.io.*;
import java.util.*;

public class Boj_15240_Paint {
    static int n, m;
    static char[][] map;
    //static int[][] d = {{-1,0}, {0,1}, {1, 0}, {0 ,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        map = new char[n][];

        for(int i = 0 ; i <n; ++i)
            map[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char color = st.nextToken().charAt(0);
        dfs2(x, y, color, map[x][y]);
        //dfs(x, y, color, map[x][y]);

        for(int i = 0; i < n; ++i){
            for(int j = 0 ; j < m; ++j)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    /*static void dfs(int x,int y, char ch, char org){
        map[x][y] = ch;
        for(int i = 0 ; i < 4; ++i){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == org) {
                dfs(nx, ny, ch, org);
            }
        }
    }*/

    static void dfs2(int x,int y, char ch, char org){
        if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] != org) return;
        map[x][y] = ch;
        dfs2(x + 1, y, ch, org);
        dfs2(x - 1, y, ch, org);
        dfs2(x, y + 1, ch, org);
        dfs2(x, y - 1, ch, org);
    }
}
