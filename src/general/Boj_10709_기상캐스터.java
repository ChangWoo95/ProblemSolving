package general;

import java.io.*;
import java.util.*;

public class Boj_10709_기상캐스터 {
    static int n,m;
    static int[][] minutes;
    static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        minutes = new int[n][m];

        for(int i =0; i < n; i++){
            Arrays.fill(minutes[i], -1);
            map[i] = br.readLine().toCharArray();
        }
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++)
                if(map[i][j] == 'c') move(i, j);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i <n; i++){
            for(int j = 0; j < m; j++)
                sb.append(minutes[i][j]).append(" ");
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void move(int x, int y){
        minutes[x][y] = 0;
        while(true){
            int ny = y + 1;
            if(ny >= m) break;
            if(minutes[x][ny] != -1)
                minutes[x][ny] = Math.min(minutes[x][ny], minutes[x][y] + 1);
            else minutes[x][ny] = minutes[x][y] + 1;
            y++;
        }
    }
}
