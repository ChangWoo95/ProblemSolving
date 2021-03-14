package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2436_공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());
        lcm /= gcd;
        long ans = 0;
        for (int i = 1; i * i <= lcm; ++i) {
            if (lcm % i == 0 && getGCD( i, lcm/ i) == 1) {
                ans = i;
            }
        }
        System.out.println(ans * gcd + " " + (lcm / ans) * gcd);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
