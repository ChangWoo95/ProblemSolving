package general;

import java.io.*;
import java.util.*;

public class Boj_1780_종이의개수 {
    static int[][] map;
    static int zero = 0, one = 0, mione = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        split(0, 0, n);
        sb.append(mione).append("\n").append(zero).append("\n").append(one).append("\n");
        System.out.print(sb);
    }

    static void split(int x, int y, int n) {
        if (isSame(x, y, n)) {
            if (map[x][y] == 0) ++zero;
            else if (map[x][y] == 1) ++one;
            else ++mione;
            return;
        }

        for(int i = 0 ; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                split(x + (i * n / 3), y + (j * n / 3), n/3);
            }
        }
    }

    static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x + n; ++i) {
            for (int j = y; j < y + n; ++j) {
                if (map[i][j] != map[x][y]) return false;
            }
        }
        return true;
    }
}
