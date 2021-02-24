package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_18291_비요뜨의징검다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t< T; ++t) {
            int x = Integer.parseInt(br.readLine());
            if(x == 1) sb.append(1).append("\n");
            else sb.append(dc(2, x-2 ,1000000007)).append("\n");
        }
        System.out.print(sb);
    }
    public static long dc(int a, int b, int remain) {
        if (b == 0) return 1;
        long n = dc(a, b / 2, remain);
        long temp = n * n % remain;
        if (b % 2 == 0) return temp;
        else return a * temp % remain;
    }
}
