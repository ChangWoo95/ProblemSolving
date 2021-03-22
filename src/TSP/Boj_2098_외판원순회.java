package TSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2098_외판원순회 {
    static int n;
    static int[][] map, dp;
    static final int INF = 18000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], INF);
        }

        System.out.println(TSP(1, 0));
    }

    static int TSP(int visited, int x) {
        if (visited == (1 << n) - 1) {
            if(map[x][0] != 0) return map[x][0]; // 전부다 방문한 경우라면
            return INF;
        }

        if (dp[x][visited] != INF) return dp[x][visited]; // 이미 존재하는 경로였다면

        for (int i = 0; i < n; ++i) {
            if (map[x][i] == 0 || (visited & (1 << i)) != 0) continue;
            dp[x][visited] = Math.min(dp[x][visited], TSP((visited | (1 << i)), i) + map[x][i]);
        }
        return dp[x][visited];
    }
}
