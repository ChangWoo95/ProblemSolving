package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17265_나의인생에는수학과함께 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = {{0, 1}, {1, 0}};
    static int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][];
        visited = new boolean[n][n];

        for(int i = 0 ; i <n; ++i){
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, map[0][0] - '0', '0');

    }
    static void dfs(int cx,int cy, int sum, char operand){
        visited[cx][cy] = true;
        for(int i = 0 ; i < 2; ++i){
            int nx = cx + d[i][0];
            int ny = cy + d[i][1];
            if(isIn(nx, ny) && !visited[nx][ny]){
                if(Character.isDigit(map[nx][ny])){

                } else {
                    operand = map[nx][ny];
                    dfs(nx, ny, sum, '1');

                }
            }
        }
    }

    static boolean isIn(int posX, int posY){
        return posX >= 0 && posX < n && posY >= 0 && posY < n;
    }

}
