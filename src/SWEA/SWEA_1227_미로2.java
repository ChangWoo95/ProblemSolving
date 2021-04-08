package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227_미로2 {
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int sx, sy, ex, ey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=10; ++i){
            int t = Integer.parseInt(br.readLine());
            map = new char[100][];
            visited = new boolean[100][100];
            for(int x = 0; x < 100; ++x){
                map[x] = br.readLine().toCharArray();
                for(int y = 0; y < 100; ++y){
                    if(map[x][y] == '2') {
                        sx = x;
                        sy = y;
                    } else if(map[x][y] == '3'){
                        ex = x;
                        ey = y;
                    }
                }
            }
            if(bfs(sx, sy)) sb.append("#"+t).append(" " + 1).append("\n");
            else sb.append("#"+t).append(" " + 0).append("\n");
        }
        System.out.print(sb);
    }
    static boolean bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for(int i = 0 ; i < 4; ++i){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                if(nx <0 || nx >= 100 || ny < 0 || ny >= 100 ) continue;
                if(!visited[nx][ny]){
                    if(map[nx][ny] == '3'){
                        return true;
                    }
                    else if(map[nx][ny] == '0'){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
