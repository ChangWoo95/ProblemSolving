package SWEA;

import java.awt.*;
import java.io.*;
import java.util.*;

public class SWEA_최적경로 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] visited;
    static Point[] pos;
    static Point company, home;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(br.readLine());
            pos = new Point[n];
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i = 0 ; i <n; i++)
                pos[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            perm(0, 0, company.x, company.y);
            sb.append("#" + t +" ").append(minDist).append("\n");
            minDist = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }
    static void perm(int depth, int dist, int x,int y){
        if(dist > minDist) return;
        if(depth == n){
            minDist = Math.min(minDist, dist + Math.abs(x - home.x) + Math.abs(y - home.y));
            return;
        }
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(depth+1, dist + Math.abs(x - pos[i].x) + Math.abs(y - pos[i].y), pos[i].x, pos[i].y);
                visited[i] = false;
            }
        }
    }
}
