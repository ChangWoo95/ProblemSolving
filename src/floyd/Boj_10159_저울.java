package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10159_저울 {
    static final int INF = (int)1e9;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t< T; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            map[x][y] = 1;
        }
        floyd();
        for(int i = 0 ; i <n; ++i){
            int cnt = 0;
            for(int j = 0 ; j < n; ++j){
                if(map[i][j] == 0 && map[j][i] == 0) ++cnt;
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.print(sb);
    }
    static void floyd(){
        for(int k = 0 ; k < n; ++k){
            for(int i = 0 ; i < n; ++i){
                for(int j = 0 ; j < n; ++j){
                    if(map[i][k] != 0 && map[k][j] != 0) map[i][j] = 1;
                }
            }
        }
    }
}
