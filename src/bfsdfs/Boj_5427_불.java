package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_5427_불 {

    static int n, m;
    static char[][] map;
    static Queue<int[]> q;
    static StringBuilder sb = new StringBuilder();
    static int cx, cy;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new char[n][];
            int cx = 0, cy = 0;
            q = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; ++j) {
                    if (map[i][j] == '*') q.add(new int[]{i, j, '*'});
                    else if (map[i][j] == '@') {
                        cx = i;
                        cy = j;
                    }
                }
            }
            q.add(new int[]{ cx, cy, '@' });
            bfs();
        }
        System.out.print(sb);

    }

    static void bfs() {
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        visited[cx][cy] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size -- > 0) {
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                char c = (char) q.peek()[2];
                q.poll();
                if(c == '@' && (cx == 0 || cx == n-1 || cy == 0 || cy == m-1) ){
                    sb.append(cnt+1).append("\n");
                    return;
                }

                for (int i = 0; i < 4; ++i) {
                    int nx = cx + d[i][0];
                    int ny = cy + d[i][1];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (!visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                        q.add(new int[]{nx, ny, c});
                        map[nx][ny] = c;
                        visited[nx][ny] = true;
                    }
                }
            }
            ++cnt;
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
}
