package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj_2239_스도쿠 {
    static char[][] map;
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[] line = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[9][];
        for (int i = 0; i < 9; ++i) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < 9; ++j) {
                if (map[i][j] == '0') list.add(new int[]{i, j});
            }
        }
        play(0);
    }

    static void play(int depth) {
        if (depth == list.size()) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        for (int i = 1; i <= 9; ++i) {
            int x = list.get(depth)[0];
            int y = list.get(depth)[1];
            map[x][y] = (char) (i + '0');
            if (isRow(x) && isCol(y) && isSquare(x, y)) play(depth + 1);
            map[x][y] = '0';
        }
    }

    static boolean isRow(int r) {
        Arrays.fill(line, false);
        for (int i = 0; i < 9; ++i) {
            if (map[r][i] == '0') continue;
            if (line[map[r][i] - '0']) return false;
            else line[map[r][i] - '0'] = true;
        }
        return true;
    }

    static boolean isCol(int c) {
        Arrays.fill(line, false);
        for (int i = 0; i < 9; ++i) {
            if (map[i][c] == '0') continue;
            if (line[map[i][c] - '0']) return false;
            else line[map[i][c] - '0'] = true;
        }
        return true;
    }

    static boolean isSquare(int r, int c) {
        Arrays.fill(line, false);
        for (int i = (r / 3) * 3; i <= (r / 3) * 3 + 2; i++) {
            for (int j = (c / 3) * 3; j <= (c / 3) * 3 + 2; j++) {
                if (map[i][j] == '0') continue;
                if (line[map[i][j] - '0']) return false;
                else line[map[i][j] - '0'] = true;
            }
        }
        return true;
    }
}
