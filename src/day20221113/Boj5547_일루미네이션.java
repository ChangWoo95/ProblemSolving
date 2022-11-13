package day20221113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * fileName       : Boj5547_일루미네이션
 * author         : changwoo95
 * date           : 2022-11-13
 * description    : 변형 bfs문제, 육각형 탐지 로직을 아느냐 모르느냐에 따라 풀 수 있는 문제
 **/
public class Boj5547_일루미네이션 {
    public static int r;
    public static int c;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int[][] oddDir = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1} };
    public static int[][] evenDir = { {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };


    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        grid = new int[r+2][c+2];
        visited = new boolean[r+2][c+2];

        for(int i = 1; i <= r; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= c; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int cx = node[0];
            int cy = node[1];

            for(int i = 0 ; i < 6; ++i) {
                int nx = 0;
                int ny = 0;
                if(cx % 2 == 0) {
                    nx = cx + evenDir[i][0];
                    ny = cy + evenDir[i][1];
                } else {
                    nx = cx + oddDir[i][0];
                    ny = cy + oddDir[i][1];
                }
                if(isIn(nx, ny)) {
                    if(grid[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    } else if(grid[nx][ny] == 1) {
                        cnt += 1;
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < r + 2 && y >= 0 && y < c+2;
    }
}
