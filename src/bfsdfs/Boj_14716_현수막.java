package bfsdfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_14716_현수막 {
    static int n, m, cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] d = { {-1,0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i <n; ++i) {
            for(int j = 0 ; j < m; ++j) {
                if(!visited[i][j] && map[i][j] == 1) bfs(i, j);
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int x,int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();

            for(int i = 0 ; i < 8; i++){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                if(nx>=0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

        cnt++;
    }
}
