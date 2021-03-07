package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11404_플로이드 {
    static final int INF = (int)1e9;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0 ; i <n; ++i){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t <T; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            map[x][y] = Integer.min(map[x][y], cost);
            //map[x][y] = cost;
        }

        floyd();

        for(int i = 0 ; i <n; ++i){
            for(int j = 0 ; j <n; ++j){
                if(map[i][j] > 0 && map[i][j] != INF) sb.append(map[i][j]).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void floyd(){
        for(int k = 0; k <n; ++k){
            for(int i = 0; i< n; ++i){
                for(int j = 0; j < n; ++j){
                    map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
