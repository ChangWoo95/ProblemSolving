package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1600_말이되고픈원숭이 {
    static int cnt;
    static int[][] map;
    static int r,c;
    static boolean[][][] visited;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c][cnt+1];

        for(int i = 0 ; i <r; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < c; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][cnt] = true;
        q.add(new int[]{0, 0, cnt, 0});
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int k = q.peek()[2];
            int val = q.peek()[3];
            q.poll();
            if (x == r - 1 && y == c - 1) {
                System.out.println(val);
                return;
            }

            for(int i = 0 ; i < 12; ++i){
                if(i >= 4 && k <= 0) break;
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(map[nx][ny] == 1) continue;

                if( i < 4 && !visited[nx][ny][k]){
                    visited[nx][ny][k] = true;
                    q.add(new int[]{nx, ny, k, val + 1});
                } else if(i >= 4 && !visited[nx][ny][k - 1]){
                    visited[nx][ny][k-1] = true;
                    q.add(new int[]{nx, ny, k - 1, val + 1});
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
