package IM;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_2564_경비원 {
    static class Node{
        int d;
        int x;
        int y;
        Node(int d, int dd, int r, int c){
            this.d = d;
            if (d == 1) {
                this.y = dd;
                this.x = 0;
            } else if (d == 2) {
                this.y = dd;
                this.x = r;
            } else if (d == 3) {
                this.y = 0;
                this.x = dd;
            } else {
                this.y = c;
                this.x = dd;
            }
        }
    }
    static int r,c,n;
    static int[][] map;
    static Node[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        int result = 0;
        pos = new Node[n];
        for(int i = 0 ; i <n; i++){
            st = new StringTokenizer(br.readLine());
            pos[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), r, c);
        }
        st = new StringTokenizer(br.readLine());
        Node dest = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), r, c);
        int inv = 0;
        if(dest.d == 1) inv = 2;
        else if(dest.d == 2) inv = 1;
        else if(dest.d == 3) inv = 4;
        else inv = 3;

        for(Node nd : pos){
            if(nd.d == inv){
                if(nd.d == 1 || nd.d == 2) result += Math.min(dest.y + nd.y + dest.x + nd.x, c - dest.y + c -  nd.y +  dest.x + nd.x);
                else result += Math.min(dest.y + nd.y + r - dest.x + r - nd.x, dest.y + nd.y + dest.x + nd.x);
            } else result += Math.abs(dest.y - nd.y) + Math.abs(dest.x - nd.x);
        }
        System.out.println(result);

    }
}
