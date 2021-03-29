package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17779_게리맨더링2 {
    static int[][] map;
    static int mapSum = 0;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                mapSum += map[i][j];
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                getBoundary(i, j);
            }
        }
        System.out.println(ans);
    }

    static void getBoundary(int x, int y) {
        for (int d1 = 1; d1 <= n; ++d1) {
            for (int d2 = 1; d2 <= n; ++d2) {
                if (x + d1 + d2 <= n && y - d1 >= 1 && y + d2 <= n) {
                    draw(x, y, d1, d2);
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                }
            }
        }
    }

    static void draw(int x, int y, int d1, int d2) {
        int sum = 0;
        int stageFiveSum = mapSum;
        boolean[][] boundaryMap = new boolean[n+1][n+1];
        for (int i = 0; i <= d1; i++) {
            boundaryMap[x + i][y - i] = true;
            boundaryMap[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            boundaryMap[x + i][y + i] = true;
            boundaryMap[x + d1 + i][y - d1 + i] = true;
        }
        for(int i =x+1; i<x+d1+d2 ; i++) {
            for (int j = 1; j<=n ;j++) {
                if(boundaryMap[i][j]) {
                    while(++j<=n && !boundaryMap[i][j]) {
                        boundaryMap[i][j]=true;
                    }
                }
            }
        }
        for (int i = 1; i < x + d1; ++i) { // stage 1
            for (int j = 1; j <= y; ++j) {
                if(!boundaryMap[i][j]) sum += map[i][j];
            }
        }
        stageFiveSum -= sum;
        findMaxMin(sum);
        sum = 0;
        for (int i = 1; i <= x + d2; ++i) { // stage 2
            for (int j = y + 1; j <= n; ++j) {
                if(!boundaryMap[i][j]) sum += map[i][j];
            }
        }
        stageFiveSum -= sum;
        findMaxMin(sum);
        sum = 0;
        for (int i = x + d1; i <= n; ++i) { // stage 3
            for (int j = 1; j < y - d1 + d2; ++j) {
                if(!boundaryMap[i][j]) sum += map[i][j];
            }
        }
        stageFiveSum -= sum;
        findMaxMin(sum);
        sum = 0;
        for (int i = x + d2 + 1; i <= n; ++i) { // stage 4
            for (int j = y - d1 + d2; j <= n; ++j) {
                if(!boundaryMap[i][j]) sum += map[i][j];
            }
        }
        stageFiveSum -= sum;
        findMaxMin(sum);
        findMaxMin(stageFiveSum);
        ans = Math.min(ans, max - min);
    }

    static void findMaxMin(int sum) {
        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }
}
