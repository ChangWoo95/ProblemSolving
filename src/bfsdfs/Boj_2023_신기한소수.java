package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2023_신기한소수 {
    static char[] number;
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new char[n];
        mulPerm(0);
        System.out.print(sb);
    }
    static void mulPerm(int depth){
        if(depth == n){
            sb.append(number).append("\n");
            return;
        }
        for(int i = 0 ; i < 10; ++i){
            if(depth == 0 && (i != 2 && i != 3 && i != 5 && i != 7) ) continue;
            number[depth] = (char)(i + '0');
            if(!isPrime(depth)) continue;
            mulPerm(depth + 1);
        }
    }
    static boolean isPrime(int depth){
        int val = Integer.parseInt(new String(number).substring(0, depth+1));
        for(int i = 2; i <= Math.sqrt(val); ++i){
            if(val % i == 0) return false;
        }
        return true;
    }
}
