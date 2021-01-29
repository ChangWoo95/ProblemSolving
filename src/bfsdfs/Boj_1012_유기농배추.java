package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012_유기농배추 {
    static int r, c,cabbage,worm;
    static int[][] field;
    static boolean[][] visited;
    static int[][] deltas = { {0,1}, {0,-1}, {1, 0}, {-1, 0} };

    static class node {
        int x;
        int y;
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int cbX, cbY;

        while(T --> 0) {
            worm = 0;
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());

            field = new int[r][c];
            visited = new boolean[r][c];
            for (int i = 0; i < cabbage; i++) {
                st = new StringTokenizer(br.readLine());
                cbY = Integer.parseInt(st.nextToken());
                cbX = Integer.parseInt(st.nextToken());
                field[cbX][cbY] = 1;
            }
            for(int i = 0; i < r; i++){
                for(int  j = 0; j < c; j++){
                    if(!visited[i][j] && field[i][j] == 1) {
                        eatingField(i, j);
                        worm++;
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.println(sb);
    }
    static void eatingField(int x, int y) {
        Queue<node> q = new LinkedList<>();
        q.add(new node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            node tmp = q.poll();
            for(int i =0; i< 4; i++){
                int nx = tmp.x + deltas[i][0];
                int ny = tmp.y + deltas[i][1];
                if(isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new node(nx, ny));
                }
            }
        }

    }
    static boolean isValid(int x, int y){
        return x >= 0 && x < r && y >= 0 && y < c && !visited[x][y] && field[x][y] == 1;
    }
}
