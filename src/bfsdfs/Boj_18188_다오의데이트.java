package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18188_다오의데이트 {
    static int r, c, k;
    static char[][] map;
    static char[][] dir;
    static int[] daoPos = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][];

        for (int i = 0; i < r; ++i) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; ++j) {
                if (map[i][j] == 'D') {
                    daoPos[0] = i;
                    daoPos[1] = j;
                }
            }
        }
        k = Integer.parseInt(br.readLine());
        dir = new char[k][2];
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; ++j) {
                dir[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs(0, daoPos[0], daoPos[1], "");
        System.out.println("NO");
    }

    static void dfs(int depth, int x, int y,String s) {
        for(int i = depth ; i < dir.length; ++i) {
            boolean flag = false;
            for (int j = 0; j < dir[i].length; ++j) {
                int nx = 0, ny = 0;
                char ch;

                if (dir[i][j] == 'W') {
                    nx = x - 1;
                    ny = y;
                    ch = 'W';
                } else if (dir[i][j] == 'D') {
                    nx = x;
                    ny = y + 1;
                    ch = 'D';
                } else if (dir[i][j] == 'A') {
                    nx = x;
                    ny = y - 1;
                    ch = 'A';
                } else { // S
                    nx = x + 1;
                    ny = y;
                    ch = 'S';
                }
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '@') continue;
                flag = true;
                if (map[nx][ny] == 'Z') {
                    System.out.println("YES" + "\n" + s + ch);
                    System.exit(0);
                }
                dfs(depth + 1, nx, ny, s + ch);
                flag = false;
            }
            if(!flag) return;
        }
    }
}
