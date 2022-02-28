package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1730_판화 {

    public static char[][] map;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String oper = br.readLine();

        map = makeMap();
        perform(oper);

        StringBuilder sb = new StringBuilder();
        for(int i =0  ; i < n; ++i) {
            for(int j = 0 ; j <n; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void perform(String oper) {
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < oper.length(); ++i) {
            switch (oper.charAt(i)) {
                case 'D':
                    if(isIn(x + 1, y)) {
                        change(x, y, '|');
                        change(++x, y, '|');
                    }
                    break;
                case 'R':
                    if(isIn(x, y + 1)) {
                        change(x, y, '-');
                        change(x, ++y, '-');
                    }
                    break;
                case 'U':
                    if(isIn(x - 1, y)) {
                        change(x, y, '|');
                        change(--x, y, '|');
                    }
                    break;
                case 'L':
                    if(isIn(x, y - 1)) {
                        change(x, y, '-');
                        change(x, --y, '-');
                    }
                    break;
            }
        }

        return;
    }

    public static boolean isIn(int x, int y) {
        return x>= 0 && x < n && y >= 0 && y < n;
    }

    public static void change(int x, int y, char ch) {
        if(map[x][y] == '.') {
            map[x][y] = ch;
        } else if(map[x][y] != ch) {
            map[x][y] = '+';
        }

        return;
    }

    public static char[][] makeMap() {
        char[][] ret = new char[n][n];

        for(int i = 0 ; i <n; ++i) {
            Arrays.fill(ret[i], '.');
        }

        return ret;
    }


}
