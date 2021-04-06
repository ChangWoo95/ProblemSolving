package SWEA;

import java.awt.*;
import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑지뢰찾기 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int cnt = 0;
    static int[][] d = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1} };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <=T; t++){
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            visited = new boolean[n][n];

            for(int i =0; i < n; i++)
                map[i] = br.readLine().toCharArray();

            for(int i =0; i <n; i++){
                for(int j = 0; j < n; j++)
                    if(map[i][j] == '.') map[i][j] = (char)(findMine(i, j) + '0');
            }
            for(int i =0; i <n; i++){
                for(int j=0; j< n; j++){
                    if(!visited[i][j] && map[i][j] =='0') {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            for(int i =0; i <n; i++){
                for(int j =0; j < n; j++) {
                    if(map[i][j] != '*' && !visited[i][j]) cnt++;
                }
            }
            sb.append("#" + t +" ").append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        if(map[x][y] != '0') {
            return;
        }
        for(int i =0; i < 8; i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(isIn(nx, ny) && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }

    }
    static int findMine(int x, int y) {
        int nx, ny;
        int count = 0;
        for(int i=0; i < 8; i++){
            nx = x + d[i][0];
            ny = y + d[i][1];
            if(isIn(nx, ny)){
                if(map[nx][ny] == '*') count++;
            }
        }
        return count;
    }
    static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
