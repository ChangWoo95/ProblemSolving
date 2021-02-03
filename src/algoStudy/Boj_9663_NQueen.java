package algoStudy;

import java.io.*;

public class Boj_9663_NQueen {
    static int cnt = 0;
    static int[] col;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        col = new int[m+1];
        for(int i =1; i<= m; i++) {
            col[1] = i;
            nqueen(1);
        }
        System.out.println(cnt);
    }
    static void nqueen(int depth){
        if(depth == m) {
            cnt++;
            return;
        }
        for(int i = 1; i <= m; i++){
            col[depth+1] = i;
            if(!isFine(depth+1)) continue;
            nqueen(depth+1);
        }
    }
    static boolean isFine(int x){
        for(int i = 1; i<x; i++){
            if(col[i] == col[x] || Math.abs(col[x] - col[i]) == (x - i)) return false; // 행이 같거나 대각선에 위치하고 있다면 실패
        }
        return true;
    }
}
