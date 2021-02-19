package bfsdfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_11123_양한마리두마리 {
    static int n, m, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][];
            visited = new boolean[n][m];
            cnt = 0;

            for(int i = 0; i <n; ++i)
                map[i] = br.readLine().toCharArray();

            for(int i = 0 ; i <n; ++i){
                for(int j = 0 ; j < m; ++j){
                    //if(!visited[i][j] && map[i][j] == '#') bfs(i, j);
                    if(!visited[i][j] && map[i][j] == '#'){
                        dfs(i,j);
                        ++cnt;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    /*static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i = 0 ; i < 4; ++i){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == '#'){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        cnt++;
    }*/
    static void dfs(int x,int y){
        if(x < 0 || x >= n || y < 0 || y>=m || visited[x][y] ||  map[x][y] == '.') return ;
        visited[x][y] = true;
        for(int i = 0 ; i <4 ; ++i){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            dfs(nx, ny);
        }
    }
}
