package IM;

import java.io.*;
import java.util.*;

public class Boj_1074_Z {
    static int N, r, c;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(0, 0, (1 << N));
    }
    static void solve(int x,int y,int n){
        if(x == r && y == c){
            System.out.println(ans);
            return;
        }
        if(r < x+n && r >= x && c < y+n && c >= y){
            solve(x, y, n/2);
            solve(x, y + n / 2, n/2);
            solve(x + n/2, y, n/2);
            solve(x + n/2, y +n/2, n/2);
        } else ans += n*n;
    }
}
