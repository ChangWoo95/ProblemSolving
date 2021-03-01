package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20057_마법사상어와토네이도 {
    static int n;
    static int remain = 0;
    static int[][] map;
    static int[][] d = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
    static int[][][] sand = { // 4 9 2;
            { {-2, 0, 2}, {-1, 1, 1}, {-1, 0, 7}, {-1, -1, 10}, {0, -2, 5}, {1, 1, 1}, {1, 0, 7}, {1, -1, 10}, {2, 0, 2} },
            { {0, -2, 2}, {-1, -1, 1}, {0, -1, 7}, {1, -1, 10}, {2, 0, 5}, {1, 1, 10}, {0, 1, 7}, {-1, 1, 1}, {0, 2, 2} },
            { {0, 2, 5}, {-1, 1, 10}, {-1, 0, 7}, {-1, -1, 1}, {-2, 0, 2}, {1, 1, 10}, {1, 0, 7}, {1, -1, 1}, {2, 0, 2} },
            { {-1, -1, 10}, {0, -1, 7}, {0, -2, 2}, {1, -1, 1}, {-2, 0, 5}, {-1, 1, 10}, {0, 1, 7}, {0, 2, 2}, {1, 1, 1} }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0 ; i < n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <n; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(n/2, n/2);
        System.out.println(remain);
    }

    static void simulation(int x,int y){
        int cnt = 0;

        while( true ){
            for(int i = 0 ; i <4; ++i){
                if(x == 0 && y == 0) return;
                if(cnt != n-1 && (i ==0 || i == 2) ) ++cnt;

                for(int nn = 0; nn < cnt; ++nn) {
                    x += d[i][0];
                    y += d[i][1];
                    if (map[x][y] == 0) continue;
                    int val = map[x][y];
                    int temp = 0;

                    for (int j = 0; j < 9; ++j) {
                        int nx = x + sand[i][j][0];
                        int ny = y + sand[i][j][1];
                        int rate = sand[i][j][2];

                        temp += (int)(val * ((double)rate / 100));
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) remain += (int)(val * ((double)rate / 100));
                        else map[nx][ny] += (int)(val * ((double)rate / 100));
                    }
                    int nx = x + d[i][0];
                    int ny = y + d[i][1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) remain += map[x][y] - temp;
                    else map[nx][ny] += map[x][y] - temp;
                    map[x][y] = 0;
                }
            }
        }
    }
}
