package IM;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_10163_색종이 {
    static class Node{
        int x,y,ylen,xlen;
        Node(int y,int x,int ylen, int xlen){
            this.y = y;
            this.x = x;
            this.ylen = ylen;
            this.xlen = xlen;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[103][103];
        Node[] pos = new Node[n+1];
        for(int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            pos[i] = new Node(Integer.parseInt(st.nextToken()),103 -  Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int j = pos[i].x - pos[i].xlen; j< pos[i].x; j++){
                for(int k = pos[i].y; k < pos[i].y + pos[i].ylen; k++){
                    map[j][k] = i;
                }
            }
        }
        for(int idx = 1; idx <= n; idx++){
            int cnt = 0;
            for(int i = pos[idx].x - pos[idx].xlen ; i< pos[idx].x ; i++){
                for(int j = pos[idx].y; j< pos[idx].ylen + pos[idx].y ; j++){
                    if(map[i][j] == idx) cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

    }
}
