package bfsdfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_2178_미로탐색 {
    static int n,m;
    static int[][] map, visited;
    static int[][] d = { {0,1}, {0, -1}, {1,0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited= new int[n][m];
        for(int i =0; i <n; i++){
            String s= br.readLine();
            for(int j =0; j <m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.print(escape());
    }
    static int escape(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == n-1 && p.y == m-1) return visited[p.x][p.y];
            for(int i =0; i <4; i++){
                int nx = p.x + d[i][0];
                int ny = p.y + d[i][1];
                if(!isIn(nx, ny)) continue;
                if(map[nx][ny] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return -1;
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
