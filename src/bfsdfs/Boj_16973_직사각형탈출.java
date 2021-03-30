package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16973_직사각형탈출 {
    static int r, c;
    static int[][] map;
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    static int[] rect;
    static int h, w;
    static int edx, edy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        rect = new int[2];
        visited = new boolean[r][c];

        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        rect[0] = Integer.parseInt(st.nextToken()) - 1;
        rect[1] = Integer.parseInt(st.nextToken()) - 1;

        edx = Integer.parseInt(st.nextToken()) - 1;
        edy = Integer.parseInt(st.nextToken()) - 1;
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[rect[0]][rect[1]] = true;
        q.add(new int[]{rect[0], rect[1], 0});

        while (!q.isEmpty()) {
            int[] list = q.poll();
            if (list[0] == edx && list[1] == edy) {
                System.out.println(list[2]);
                return;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = list[0] + d[i][0];
                int ny = list[1] + d[i][1];
                if (!isIn(nx, ny) || visited[nx][ny]) continue;
                if (test(nx, ny, i)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, list[2] + 1});
                }
            }
        }
        System.out.println(-1);
    }

    static boolean test(int x, int y, int dir) {
        if (dir == 0) {
            int ny = y + w - 1;
            if (ny >= c) return false;

            for (int i = x; i < x + h; i++) {
                if (map[i][ny] == 1) return false;
            }
        } else if (dir == 1) {
            for (int i = x; i < x + h; i++) {
                if (map[i][y] == 1) return false;
            }
        } else if (dir == 2) {
            int nx = x + h - 1;
            if (nx >= r) return false;
            for (int i = y; i < y + w; i++) {
                if (map[nx][i] == 1) return false;
            }
        } else if (dir == 3) {
            for (int i = y; i < y + w; i++)
                if (map[x][i] == 1) return false;
        }
        return true;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c && map[x][y] != 1;
    }
}
