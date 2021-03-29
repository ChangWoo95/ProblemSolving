package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13460_구슬탈출2 {
    static int n, m;
    static char[][] map;
    static int rx, ry, bx, by;
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; ++i) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        escape();
    }

    static void escape() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{rx, ry, bx, by, 0});

        while (!q.isEmpty()) {
            int crx = q.peek()[0];
            int cry = q.peek()[1];
            int cbx = q.peek()[2];
            int cby = q.peek()[3];
            int cnt = q.peek()[4];

            q.poll();
            visited[crx][cry][cbx][cby] = true;

            if(cnt >= 10){
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; ++i) {

                int nbx = cbx;
                int nby = cby;
                while (map[nbx + d[i][0] ][nby + d[i][1] ] != '#') {
                    nbx += d[i][0];
                    nby += d[i][1];
                    if (map[nbx][nby] == 'O') break;
                }

                int nrx = crx;
                int nry = cry;
                while (map[nrx + d[i][0] ][nry + d[i][1]] != '#') {
                    nrx += d[i][0];
                    nry += d[i][1];
                    if (map[nrx][nry] == 'O') break;
                }

                if (map[nbx][nby] == 'O') continue;

                if (map[nrx][nry] == 'O') {
                    System.out.println(cnt + 1);
                    return;
                }

                if (nrx == nbx && nry == nby) {
                    switch (i) {
                        case 0:
                            if (cry > cby) nby -= 1;
                            else nry -= 1;
                            break;
                        case 1:
                            if (cry > cby) nry += 1;
                            else nby += 1;
                            break;
                        case 2:
                            if (crx > cbx) nbx -= 1;
                            else nrx -= 1;
                            break;
                        case 3:
                            if (crx > cbx) nrx += 1;
                            else nbx += 1;
                            break;
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    q.offer(new int[]{nrx, nry, nbx, nby, cnt + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
