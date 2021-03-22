package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_1681_해밀턴순환회로 {
    static boolean[] visited;
    static int[][] map;
    static int n;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans);
    }
    static void dfs(int start, int idx,int cost){
        if(cost >= ans) return;
        if(idx == n-1){
            if(map[start][0] != 0){
                ans = Math.min(ans, cost + map[start][0]);
            }
            return;
        }
        for( int i=1; i<n; i++) {
            if ( map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, idx+1, map[start][i] + cost);
                visited[i] = false;
            }
        }
    }
}
