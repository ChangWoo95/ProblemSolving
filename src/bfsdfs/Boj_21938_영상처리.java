package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21938_영상처리 {
    static int n,m;
    static double[][] result;
    static int t;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer = 0;
    static final int VALUE = 255;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new double[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i <n; ++i) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j <m; ++j) {
                result[i][j] = (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) /3;
            }
        }

        t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i <n; ++i) {
            for(int j = 0 ; j <m; ++j) {
                if( !isValue(result[i][j])) result[i][j] = 0;
            }
        }
        System.out.println(getStuff());

    }

    public static int getStuff() {
        for(int i = 0 ; i < n; ++i) {
            for(int j = 0 ; j <m; ++j) {
                if(!visited[i][j] && result[i][j] > 0) {
                    bfs(i, j);
                    ++answer;
                }
            }
        }
        return answer;
    }

    public static void bfs(int x,int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int i = 0 ; i <4; ++i) {
                int nx = pos[0] + d[i][0];
                int ny = pos[1] + d[i][1];
                if(isIn(nx, ny) && !visited[nx][ny] && result[nx][ny] > 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean isValue(double val) {
        return val >= t;
    }

    public static boolean isIn(int x,int y) {
        return x>= 0 && x < n && y>= 0 && y< m;
    }
}
