package IM;

import java.io.*;
import java.util.*;

public class Boj_2999_비밀이메일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int n = s.length(), idx = 0;
        int r = 1, c;
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0 && n/i <= i) {
                r = Math.max(r, n/i);
            }
        }
        c = n / r;
        char[][] map = new char[101][101];
        for(int i = 0; i < c; i++){
            for(int j = 0; j< r;  j++){
                map[j][i] = s.charAt(idx++);
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                sb.append(map[i][j]);
            }
        }
        System.out.print(sb);
    }
}
