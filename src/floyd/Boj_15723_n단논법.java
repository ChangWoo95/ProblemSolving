package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15723_n단논법 {
    static final int INF = (int)1e9;
    static int[][] map = new int[26][26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 26; ++i){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = st.nextToken().charAt(0) -'a';
            st.nextToken();
            int y = st.nextToken().charAt(0) -'a';
            map[x][y] = 1;
        }
        n = Integer.parseInt(br.readLine());
        floyd();
        for(int i = 0 ; i <n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = st.nextToken().charAt(0) -'a';
            st.nextToken();
            int y = st.nextToken().charAt(0) -'a';
            if(map[x][y] != INF) sb.append("T").append("\n");
            else sb.append("F").append("\n");
        }
        System.out.print(sb);
    }
    static void floyd(){
        for(int k = 0; k < 26; ++k){
            for(int i = 0; i < 26; ++i){
                for(int j = 0 ; j < 26; ++j){
                    map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
