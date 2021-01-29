package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_3055_탈출 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dt = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static int r,c;
    static String[] map;
    static boolean[][][] visited;
    static int[][][] time;
    static Queue<Node> go = new LinkedList<>();
    static Queue<Node> water = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r];
        for(int i =0; i< r; i++) {
            map[i] = br.readLine();
            for(int j = 0; j <map[i].length(); j++){
                if(map[i].charAt(j) == 'S') go.add(new Node(i, j));
                else if(map[i].charAt(j) == '*') water.add(new Node(i, j));
            }
        }
        visited = new boolean[r][c][2];
        time = new int[r][c][2];
        waterSpread();
        goMove();
    }

    static void waterSpread() {
        while(!water.isEmpty()) {
            Node n = water.poll();
            visited[n.x][n.y][0] = true;
            for(int i = 0; i< 4; i++){
                int nx = n.x + dt[i][0];
                int ny = n.y + dt[i][1];
                if(nx < 0 || nx >=r || ny < 0 || ny >=c) continue;
                if(!visited[nx][ny][0] && map[nx].charAt(ny) == '.') {
                    time[nx][ny][0] = time[n.x][n.y][0] + 1;
                    visited[nx][ny][0] = true;
                    water.add(new Node(nx, ny));
                }
            }
        }
    }

    static void goMove() {
        while(!go.isEmpty()) {
            Node n = go.poll();
            if(map[n.x].charAt(n.y) == 'D') {
                System.out.println(time[n.x][n.y][1]);
                return;
            }

            for(int i = 0; i< 4; i++){
                int nx = n.x + dt[i][0];
                int ny = n.y + dt[i][1];
                if(nx < 0 || nx >=r || ny < 0 || ny >=c) continue;
                if(!visited[nx][ny][1] && map[nx].charAt(ny) != '*' && map[nx].charAt(ny) != 'X' && isPossible(n.x, n.y, nx, ny)) {
                    time[nx][ny][1] = time[n.x][n.y][1] + 1;
                    visited[nx][ny][1] = true;
                    go.add(new Node(nx, ny));
                }
            }
        }
        System.out.println("KAKTUS");
        return;
    }
    static boolean isPossible(int cx, int cy, int nx, int ny) {
        if(time[cx][cy][1] + 1 < time[nx][ny][0] || time[nx][ny][0] == 0) return true;
        return false;
    }
}
