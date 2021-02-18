package simulation;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_15683_감시 {
    static int[][] map, copymap;
    static int n,m;
    static ArrayList<Point> pos = new ArrayList<>();
    static int minCnt = Integer.MAX_VALUE;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static int[] output;
    static int zeroCnt = 0, zero;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copymap = new int[n][];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1<= map[i][j] && map[i][j] <= 5) pos.add(new Point(i, j));
                if(map[i][j] == 0) ++zeroCnt;
            }
        }
        output = new int[pos.size()];
        findrotate(0);
        System.out.println(minCnt);
    }
    static void findrotate(int depth){
        if(depth == output.length){
            for(int i = 0 ; i < n; i++)
                copymap[i] = map[i].clone();
            zero = zeroCnt;
            findMinLand();
            return;
        }
        for(int i = 0; i < 4; i++){
            output[depth] = i;
            findrotate(depth + 1);
        }
    }
    static void findMinLand(){
        for(int i = 0 ; i < pos.size();i++){
            int x = pos.get(i).x;
            int y = pos.get(i).y;
            switch (copymap[x][y]){
                case 1:
                    detect(x, y, output[i]);
                    break;
                case 2:
                    detect(x, y, output[i]);
                    detect(x, y, (output[i]+2) % 4);
                    break;
                case 3:
                    detect(x, y, output[i]);
                    detect(x, y, (output[i]+1) % 4);
                    break;
                case 4:
                    detect(x, y, output[i]);
                    detect(x, y, (output[i]+1) % 4);
                    detect(x, y, (output[i]+2) % 4);
                    break;
                case 5:
                    for(int j = 0; j < 4; j++)
                        detect(x, y, j);
                    break;
            }
        }
        minCnt = Integer.min(minCnt, zero);
    }
    static void detect(int x,int y, int d){
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];
        while(isIn(nx, ny) && copymap[nx][ny] != 6){
            if(copymap[nx][ny] == 0) {
                copymap[nx][ny] = -1;
                --zero;
            }
            nx += dir[d][0]; ny += dir[d][1];
        }
    }
    static boolean isIn(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
}
