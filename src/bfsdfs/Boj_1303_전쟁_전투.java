package bfsdfs;

//import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_1303_전쟁_전투 {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static int wCnt = 0, bCnt = 0;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][];
        visited = new boolean[n][m];

        for(int i = 0 ; i <n; ++i)
            map[i] = br.readLine().toCharArray();

        for(int i = 0 ; i < n; ++i){
            for(int j = 0 ; j < m; ++j){
                if(!visited[i][j]){
                    cnt = 0;
                    if(map[i][j] == 'W') {
                        dfs(i, j, map[i][j]);
                        wCnt += cnt * cnt;
                    } else {
                        dfs(i, j, map[i][j]);
                        bCnt += cnt * cnt;
                    }
                }
            }
        }
        System.out.print(wCnt + " " + bCnt);
    }

    static void dfs(int x, int y, char ch) {
        if(x < 0 || x>= n || y < 0 || y >= m || visited[x][y] || map[x][y] != ch) return ;
        ++cnt;
        visited[x][y] = true;
        for(int i= 0 ; i < 4; i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            dfs(nx, ny, ch);
        }
    }

    /*static void bfs(int x, int y, char ch) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int cx = q.peek().x, cy = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == ch) {
                    visited[nx][ny] = true;
                    ++cnt;
                    q.add(new Point(nx, ny));
                }
            }
        }

        if(ch == 'W') wCnt += cnt * cnt;
        else bCnt += cnt * cnt;
    }*/

}
