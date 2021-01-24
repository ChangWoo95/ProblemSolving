package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_B1_10829_이진수변환 {
    static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        String ans = convertBin(n);
        System.out.println(ans);
    }

    static String convertBin(BigInteger n) {
        if( n.divide(BigInteger.valueOf(2)) == BigInteger.ZERO){
            s = n.remainder(BigInteger.valueOf(2)) + s;
            return s;
        } else {
            s = n.remainder(BigInteger.valueOf(2)) + s;
            return convertBin(n.divide(BigInteger.valueOf(2)));
        }
    }
}
