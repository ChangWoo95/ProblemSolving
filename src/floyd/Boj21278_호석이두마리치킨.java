package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj21278_호석이두마리치킨 {

    public static int n,m;
    public static int[][] map;
    public static int[] choosed;

    public static final int INF = (int) 1e9;
    public static int minSum = Integer.MAX_VALUE;
    public static int smallNum = 101, bigNum = 101;

    public static void main(String[] args) throws IOException {
        input();
        floyd();
        comb(0, 0);
        System.out.println((smallNum + 1) + " " + (bigNum + 1) + " " + minSum);
    }

    public static void comb(int depth, int start) {
        if(depth == 2) {
            int house1 = choosed[0];
            int house2 = choosed[1];
            int sum = 0;

            for(int i = 0 ; i <n; ++i) {
                if(i != house1 && i != house2) {
                    sum += Math.min(map[house1][i], map[house2][i]) * 2;
                }
            }

            if(sum < minSum) {
                minSum = sum;
                smallNum = house1;
                bigNum = house2;
            }
            return;
        }
        for(int i = start; i < n; ++i) {
            choosed[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    public static void floyd() {
        for(int k = 0 ; k <n; ++k) {
            for(int i = 0 ; i < n; ++i) {
                for(int j = 0 ; j < n; ++j) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        choosed = new int[2];

        for(int i = 0 ; i < n; ++i) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i = 0 ; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
    }
}
