package bfsdfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_7562_나이트의이동 {
    static int[][] map, visited ,d = { {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2} };
    static int n;
    static int stX, stY, edX, edY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t =0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new int[n][n];
            for(int i =0; i < n; i++)
                Arrays.fill(visited[i], -1);
            st = new StringTokenizer(br.readLine());
            stX = Integer.parseInt(st.nextToken());
            stY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            edX = Integer.parseInt(st.nextToken());
            edY = Integer.parseInt(st.nextToken());
            sb.append(moveKnight(stX, stY)).append("\n");
        }
        System.out.print(sb);
    }
    static int moveKnight(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == edX && p.y == edY) return visited[p.x][p.y];
            for(int i =0; i <8; i++){
                int nx = p.x + d[i][0];
                int ny = p.y + d[i][1];
                if(!isIn(nx, ny)) continue;
                if(visited[nx][ny] == -1){
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return -1;
    }
    static boolean isIn(int x, int y){
        return x>=0 && x< n && y >=0 && y < n;
    }
}
