package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1956_운동 {
    static final int INF = (int)1e9;
    static int[][] map;
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        map = new int[v][v];
        for(int i = 0 ; i <v; ++i){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        int e = Integer.parseInt(st.nextToken());
        for(int t = 0; t <e; ++t){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            map[x][y] = Integer.min(map[x][y], cost);
        }

        floyd();

        int ans = INF;
        for(int i = 0 ; i <v; ++i){
            for(int j = 0 ; j <v; ++j){
                if(i == j) continue;
                if(map[i][j] != INF && map[j][i] != INF ) ans = Integer.min(ans,map[i][j]+map[j][i]);
            }
        }
        if(ans == INF ) System.out.print(-1);
        else System.out.print(ans);
    }

    static void floyd(){
        for(int k = 0; k <v; ++k){
            for(int i = 0; i< v; ++i){
                for(int j = 0; j < v; ++j){
                    map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
