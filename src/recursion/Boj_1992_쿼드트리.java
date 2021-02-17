package recursion;

import java.io.*;

public class Boj_1992_쿼드트리 {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();
        solve(0, 0, N);
        System.out.print(sb);
    }

    static void solve(int x, int y, int n) {
        int val = isSame(x, y, n);
        if (val == 1 || val == 0) {
            sb.append(val);
            return;
        }
        sb.append("(");
        solve(x, y, n / 2);
        solve(x, y + n / 2, n / 2);
        solve(x + n / 2, y, n / 2);
        solve(x + n / 2, y + n / 2, n / 2);
        sb.append(")");
    }

    static int isSame(int x, int y, int n) {
        int cnt0 = 0; int cnt1 = 0;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (map[i][j] == '1') ++cnt1;
                else ++cnt0;
            }
        }
        if (cnt1 == 0) return 0;
        else if (cnt0 == 0) return 1;
        else return -1;
    }
}
