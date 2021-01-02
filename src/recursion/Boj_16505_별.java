package recursion;

import java.io.*;
import java.util.*;

public class Boj_16505_별 {
    static char[][] map = new char[1025][1025];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map[0][0] = '*';
        recur(0);
    }
    static void recur(int depth) {
        if(depth == n){

        }

    }
}
