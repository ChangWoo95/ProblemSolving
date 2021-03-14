package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14938_서강그라운드 {
    static final int INF = (int)1e9;
    static int n,m;
    static int[] jew;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        jew = new int[n];
        map = new int[n][n];

        for(int i = 0 ; i < n; ++i){
            jew[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0 ; j <n; ++j){
                if(i == j) continue;
                map[i][j] = INF;
            }
        }
        for(int i = 0 ; i < t; ++i){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()) - 1;
            int from = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            map[to][from] = cost;
            map[from][to] = cost;
        }

        for(int k = 0; k < n; ++k){
            for(int i = 0 ; i < n; ++i){
                for(int j = 0 ; j < n; ++j){
                    map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int maxCnt = 0;
        for(int i = 0 ; i < n; ++i){
            int result = 0;
            for(int j = 0 ; j < n; ++j){
                if(map[i][j]  <= m) result += jew[j];
            }
            maxCnt = Integer.max(maxCnt, result);
        }
        System.out.print(maxCnt);
    }

}
