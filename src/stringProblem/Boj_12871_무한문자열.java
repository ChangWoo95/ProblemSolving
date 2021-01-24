package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12871_무한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        int sb1Len = sb1.toString().length();
        int sb2Len = sb2.toString().length();
        int lcmLen = lcm(sb1Len, sb2Len);

        for(int i = 1; i <lcmLen / sb1Len; i++) {
            sb1.append(s1);
        }
        for(int i = 1; i <lcmLen / sb2Len; i++) {
            sb2.append(s2);
        }

        if(sb1.toString().equals(sb2.toString())) System.out.println(1);
        else System.out.println(0);
    }

    static int lcm(int a, int b) {
        int a1 = Math.max(a, b);
        int b1 = Math.min(a, b);
        while(b1 != 0) { //최대 공약수 구하는 부분
            int r = a1 % b1;
            a1 = b1;
            b1 = r;
        }
        return ((a*b)/a1);
    }
}
