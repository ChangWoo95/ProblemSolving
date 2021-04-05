package IM;
import java.io.*;
import java.util.*;

public class Boj_10157_자리배정 {
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static int cnt = 1;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); int r = Integer.parseInt(st.nextToken()); int p = Integer.parseInt(br.readLine());
        map = new int[r][c];

        if(c * r  < p) System.out.println(0);
        else {
            int x = r - 1;
            int y = 0;
            int dir = 0;
            while(cnt != p) {
                map[x][y] = cnt;
                int nx = x + d[dir][0];
                int ny = y + d[dir][1];

                if(nx < 0 || ny < 0 || nx >=r || ny >= c || map[nx][ny] != 0){
                    dir = (dir + 1) % 4;
                    nx = x + d[dir][0];
                    ny = y + d[dir][1];
                }

                x = nx;
                y = ny;
                cnt++;
            }
            System.out.println((y+1) +" " + (r-x) );
        }
    }
}
