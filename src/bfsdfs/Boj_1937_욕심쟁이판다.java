package bfsdfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1937_욕심쟁이판다 {
    static int n;
    static int[][] dp;
    static int[][] map;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                day = Integer.max(day, dfs(i, j));
            }
        }
        System.out.println(day);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];


        dp[x][y] = 1;
        int temp = 0;
        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[x][y] >= map[nx][ny]) continue;
            temp = Integer.max(temp, dfs(nx, ny));
        }
        dp[x][y] +=temp;

        return dp[x][y];
    }
}
