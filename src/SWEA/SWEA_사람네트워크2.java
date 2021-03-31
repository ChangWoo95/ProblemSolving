package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_사람네트워크2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        final int INF = (int)1e9;

        for (int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            for(int i = 0 ; i < n; ++i){
                for(int j = 0 ; j < n; ++j){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i != j && map[i][j] == 0){
                        map[i][j] = INF;
                    }
                }
            }
            for(int k = 0 ; k <n; ++k){
                for(int i = 0 ; i<n; ++i){
                    for(int j = 0 ; j <n; ++j){
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
            int result = INF;
            for(int i = 0 ; i < n; ++i){
                int sum = 0;
                for(int j = 0 ; j <n; ++j){
                    sum+= map[i][j];
                }
                result = Math.min(result, sum);
            }
            sb.append("#"+t+" "+result).append("\n");
        }
        System.out.print(sb);
    }
}
