package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2168_타일위의대각선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result = gcd(x, y);
        System.out.println(x+y - result);
    }
    static int gcd(int x, int y){
        int tmp;
        while(y != 0){
            tmp = x%y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
