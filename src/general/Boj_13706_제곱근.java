package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_13706_제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        BigInteger one = BigInteger.ONE;
        BigInteger two = new BigInteger("2");

        BigInteger tar = new BigInteger(num);

        BigInteger left = BigInteger.ONE;
        BigInteger right = new BigInteger(num);

        BigInteger mid, x;
        while(left.compareTo(right) <= 0){
            mid = (left.add(right)).divide(two);
            x = mid.multiply(mid);

            int ret = x.compareTo(tar);
            if(ret == 0){
                System.out.println(mid.toString());
                break;
            } else if(ret == - 1){
                left = mid.add(one);
            } else if(ret == 1){
                right = mid.subtract(one);
            }
        }
    }
}
