package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1726_로봇 {
    static int r,c;
    static int[][] map;
    static boolean[][] visited;
    static int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static int[] start = new int[3], end = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];

        for(int i = 0 ; i <r; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < c; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 3; ++i){
            start[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 3; ++i){
            end[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], });
    }
}
